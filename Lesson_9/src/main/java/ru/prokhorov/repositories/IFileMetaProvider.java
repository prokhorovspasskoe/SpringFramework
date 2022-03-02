package ru.prokhorov.repositories;

import ru.prokhorov.entities.FileMetaDTO;

import java.util.Collection;
import java.util.UUID;

public interface IFileMetaProvider {
    String checkFileExists(UUID fileHash);

    void saveFileMeta(UUID Hash, String fileName, int sybType);

    Collection<FileMetaDTO> getMetaFiles(int subtype);

   void deleteFileMetaData(UUID md5);
}
