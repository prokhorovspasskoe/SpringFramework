package ru.prokhorov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Sick {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Registry registry = context.getBean("Registry", Registry.class);
        registry.getTicket();
    }
}
