package org.kev.filemanager.application.impl;

import org.kev.filemanager.application.services.IFileService;
import org.kev.filemanager.domain.VoDirectory;
import org.kev.filemanager.domain.exceptions.FileException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
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
    public VoDirectory getProperties(String namePath) {
        try {
            VoDirectory voDirectory = new VoDirectory();

            File file = new File(namePath);

            if (file.isFile()) {
                throw new FileException("La ruta enviada no es un directorio");
            }
            voDirectory.setName(file.getName());
            voDirectory.setPath(file.getPath());
            voDirectory.setDirectory(true);
            voDirectory.setSizeBytes(Files.size(file.toPath()));
            voDirectory.setDateLastModified(getLocalDateTime(file.lastModified()));
            voDirectory.setChildren(this.getChildren(file));


            return voDirectory;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
                    e.printStackTrace();
                }

                return voDirectory;
            }).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private LocalDateTime getLocalDateTime(long date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date),
                TimeZone.getDefault().toZoneId());
    }
}
