package org.kev.filemanager.application.impl;

import org.kev.filemanager.application.services.IFileService;
import org.kev.filemanager.domain.VoDirectory;
import org.kev.filemanager.domain.exceptions.FileException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

/**
 * @author kevin
 * @version 1.0
 * @since 2023-02-23
 * @see IFileService
 */
public class FileService implements IFileService {

    @Override
    public VoDirectory getProperties(String namePath)  {
        VoDirectory voDirectory = new VoDirectory();

        File file = new File(namePath);

        Path path = Paths.get(namePath);

        if (Files.notExists(path)) {
            throw new FileException("La ruta enviada no existe");
        }

        if (Files.isDirectory(path)){
            try{
                voDirectory.setName(file.getName());
                voDirectory.setPath(file.getPath());
                voDirectory.setDirectory(true);
                voDirectory.setSizeBytes(Files.size(file.toPath()));
                voDirectory.setDateLastModified(this.getLocalDateTime(file.lastModified()));
                voDirectory.setChildren(this.getChildren(file));
            }catch(IOException e){
                throw new FileException("La ruta enviada no existe");
            }
        } else{
            throw new FileException("La ruta enviada no es un directorio");
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
                voDirectory.setDateLastModified(getLocalDateTime(file.lastModified()));

                try {
                    voDirectory.setSizeBytes(Files.size(file.toPath()));
                } catch (IOException e) {
                    throw new FileException("La ruta enviada no existe");
                }

                return voDirectory;
            }).collect(Collectors.toList());

        } catch (Exception e) {
            throw new FileException("La ruta enviada no existe");
        }
    }

    private LocalDateTime getLocalDateTime(long date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date),
                TimeZone.getDefault().toZoneId());
    }
}
