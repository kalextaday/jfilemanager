package org.kev.filemanager.application.impl;

import org.kev.filemanager.application.impl.search.SearchFile;
import org.kev.filemanager.application.services.IDirectory;
import org.kev.filemanager.application.utils.DateTimeUtil;
import org.kev.filemanager.domain.VoDirectory;
import org.kev.filemanager.domain.exceptions.EnumError;
import org.kev.filemanager.domain.exceptions.FileException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kevin
 * @version 1.0
 * @since 2023-02-23
 * @see IDirectory
 */
public class DirectoryService implements IDirectory {

    @Override
    public VoDirectory getProperties(String namePath)  {
        VoDirectory voDirectory = new VoDirectory();

        File file = new File(namePath);

        Path path = Paths.get(namePath);

        if (Files.notExists(path)) {
            throw new FileException(EnumError.PATH_NOT_FOUND.getMessage());
        }

        if (Files.isDirectory(path)){
            try{
                voDirectory.setName(file.getName());
                voDirectory.setPath(file.getPath());
                voDirectory.setDirectory(true);
                voDirectory.setSizeBytes(Files.size(file.toPath()));
                voDirectory.setDateLastModified(DateTimeUtil.getLocalDateTime(file.lastModified()));
                voDirectory.setChildren(this.getChildren(file));
            }catch(IOException e){
                throw new FileException(EnumError.PATH_NOT_FOUND.getMessage());
            }
        } else{
            throw new FileException(EnumError.PATH_IS_NOT_DIRECTORY.getMessage());
        }

        return voDirectory;
    }

    @Override
    public List<VoDirectory> getChildren(File fileDirectory) {
        try {
            File[] filesAndDirectories = fileDirectory.listFiles();

            List<File> directoriesList = Arrays.asList(filesAndDirectories);

            return directoriesList.stream().map(file -> {
                VoDirectory voDirectory = new VoDirectory();
                voDirectory.setName(file.getName());
                voDirectory.setPath(file.getPath());
                voDirectory.setDirectory(file.isDirectory());
                voDirectory.setDateLastModified(DateTimeUtil.getLocalDateTime(file.lastModified()));

                try {
                    voDirectory.setSizeBytes(Files.size(file.toPath()));
                } catch (IOException e) {
                    throw new FileException(EnumError.PATH_NOT_FOUND.getMessage());
                }

                return voDirectory;
            }).collect(Collectors.toList());

        } catch (Exception e) {
            throw new FileException(EnumError.PATH_NOT_FOUND.getMessage());
        }
    }

    @Override
    public List<VoDirectory> searchFile(String pathStart, String textParameter, String typeSearch){

        SearchFile searchFile = new SearchFile(pathStart, textParameter);

        return searchFile.search(typeSearch);

    }

}
