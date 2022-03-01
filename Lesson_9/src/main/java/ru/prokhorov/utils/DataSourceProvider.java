package ru.prokhorov.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.NonNull;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.sql2o.Sql2o;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
public class DataSourceProvider implements TransactionManagementConfigurer {
    private String USER_NAME;

    private String PASSWORD;

    private String DATASOURCE_URL;

    private String DRIVER_CLASS_NAME;

    @Override
    @NonNull
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setUsername(USER_NAME);
        config.setPassword(PASSWORD);
        config.setJdbcUrl(DATASOURCE_URL);
        config.setDriverClassName(DRIVER_CLASS_NAME);

        return new HikariDataSource(config);
    }

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(dataSource());
    }
}
