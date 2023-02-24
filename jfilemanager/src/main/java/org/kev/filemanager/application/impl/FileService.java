package org.kev.filemanager.application.impl;

import org.kev.filemanager.application.services.IFile;
import org.kev.filemanager.domain.exceptions.EnumError;
import org.kev.filemanager.domain.exceptions.FileException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileService implements IFile {

    @Override
    public byte[] getBytesOfFile(String path) {
        try{
            File file = new File(path);
            return Files.readAllBytes(file.toPath());
        }catch (IOException e){
            throw new FileException(EnumError.FILE_NOT_EXISTS.getMessage());
        }
    }
}
