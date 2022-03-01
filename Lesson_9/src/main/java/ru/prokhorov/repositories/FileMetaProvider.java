package ru.prokhorov.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.prokhorov.entities.FileMetaDTO;

import java.util.Collection;
import java.util.UUID;

public class FileMetaProvider implements IFileMetaProvider{
    private static final String GET_FILES_META = "select hash, filename from vma.file_info_metadata where sub_type = :subtype";

    private static final String GET_FILE_PATH_BY_HASH = "select filename from vma.file_info_metadata where hash = :hash";

    private static final String SAVE_FILE_META_DATA = "insert into vma.file_info_metadata (hash, filename, sub_type)\n" +
            "values (:hash, :finame, :subtype)";

    private final Sql2o sql2o;

    public FileMetaProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public String checkFileExists(UUID fileHash) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(GET_FILE_PATH_BY_HASH, false)
                    .addParameter("hash", fileHash)
                    .executeScalar(String.class);
        }
    }

    @Override
    public void saveFileMeta(UUID fileHash, String fileName, int sybType) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery(SAVE_FILE_META_DATA)
                    .addParameter("hash", fileHash)
                    .addParameter("finame", fileName)
                    .addParameter("subtype", sybType)
                    .executeUpdate();
        }
    }

    @Override
    public Collection<FileMetaDTO> getMetaFiles(int subtype) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(GET_FILES_META, false)
                    .addParameter("subtype", subtype)
                    .executeAndFetch(FileMetaDTO.class);
        }
    }

}
