package org.kev.filemanager.application.impl.search;

import org.kev.filemanager.application.utils.DateTimeUtil;
import org.kev.filemanager.domain.VoDirectory;
import org.kev.filemanager.domain.exceptions.EnumError;
import org.kev.filemanager.domain.exceptions.FileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchFile {

    private static final String SEARCH_BY_FULL_NAME = "full";
    private static final String SEARCH_BY_CONTAINS_NAME = "contains";
    private static final String SEARCH_BY_SIZE = "size";
    private static final String SEARCH_BY_LAST_MODIFIED = "last_modified";

    private final Path path;
    private final String searchParameter;

    public SearchFile(String pathStart, String searchParameter) {
        this.path = Paths.get(pathStart);
        this.searchParameter = searchParameter;
    }

    /**
     * Busca archivos por nombre completo o parcial
     * @param searchType parametro para el tipo de busqueda puede ser: full o contains
     * @return
     */
    public List<VoDirectory> search(String searchType){

        switch (searchType){
            case SEARCH_BY_FULL_NAME:
                return this.searchFileByFullName();
            case SEARCH_BY_CONTAINS_NAME:
                return this.searchFileByContainsName();
            case SEARCH_BY_SIZE:
                return this.searchFileByFileSize();
            case SEARCH_BY_LAST_MODIFIED:
                return this.searchFileByLastModified();
            default:
                return this.searchFileByContainsName();
        }
    }


    private List<VoDirectory> searchFileByFullName(){
        String fullFileName = this.searchParameter;

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(this.path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) -> p.getFileName().toString().equalsIgnoreCase(fullFileName))
        ) {
            result = pathStream.collect(Collectors.toList());

            return this.buildVoDirectoryFilesFounds(result);
        }catch (IOException e){
            throw new FileException(EnumError.PATH_NOT_FOUND.getMessage());
        }
    }

    private List<VoDirectory> searchFileByContainsName(){
        String partialFileName = this.searchParameter;

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(this.path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) -> p.getFileName().toString().contains(partialFileName))
        ) {
            result = pathStream.collect(Collectors.toList());

            return this.buildVoDirectoryFilesFounds(result);
        }catch (IOException e){
            throw new FileException(EnumError.PATH_NOT_FOUND.getMessage());
        }
    }

    private List<VoDirectory> searchFileByFileSize(){

        String[] values = this.searchParameter.split(":");
        long tmpMinSize = 0;
        long tmpMaxSize = 0;

        try{
            tmpMinSize = Long.parseLong(values[0]);
            tmpMaxSize = Long.parseLong(values[1]);
        }catch (NumberFormatException e){
            throw new FileException(EnumError.PARAM_VALUE_WITH_DECIMAL.getMessage());
        }

        long minSize = tmpMinSize;
        long maxSize = tmpMaxSize;

        if(minSize > maxSize){
            throw new FileException(EnumError.PARAM_SEARCH_SIZE.getMessage());
        }

        if(minSize < 0 || maxSize < 0){
            throw new FileException(EnumError.PARAM_SEARCH_SIZE.getMessage());
        }

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(this.path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) -> {
                    try {
                        if (Files.isDirectory(p)) {   // ignore directory
                            return false;
                        }
                        return Files.size(p) >= minSize && Files.size(p) <= maxSize;
                    } catch (IOException e) {
                        throw new FileException(EnumError.PATH_NOT_FOUND.getMessage());
                    }
                }

        )) {
            result = pathStream.collect(Collectors.toList());
            return this.buildVoDirectoryFilesFounds(result);
        }catch (IOException e){
            throw new FileException(EnumError.PATH_NOT_FOUND.getMessage());
        }
    }

    private List<VoDirectory> searchFileByLastModified(){
        Integer daysAgo = 0;
        try{
            daysAgo = Integer.parseInt(this.searchParameter);
        }catch (NumberFormatException e){
            throw new FileException(EnumError.PARAM_VALUE_WITH_DECIMAL.getMessage());
        }

        Instant instant = Instant.now().minus(daysAgo, ChronoUnit.DAYS);

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) -> {

                    if(Files.isDirectory(p) || !Files.isReadable(p)){
                        return false;
                    }

                    FileTime fileTime = basicFileAttributes.lastModifiedTime();
                    // negative if less, positive if greater
                    // 1 means fileTime equals or after the provided instant argument
                    // -1 means fileTime before the provided instant argument
                    int i = fileTime.toInstant().compareTo(instant);
                    return i > 0;
                }

        )) {
            result = pathStream.collect(Collectors.toList());

            return this.buildVoDirectoryFilesFounds(result);
        }catch (IOException e){
            throw new FileException(EnumError.PATH_NOT_FOUND.getMessage());
        }
    }

    private List<VoDirectory> buildVoDirectoryFilesFounds(List<Path> pathsFounds){
        return pathsFounds.stream().map(p -> {
            VoDirectory voDirectory = new VoDirectory();

            try {
                voDirectory.setName(p.getFileName().toString());
                voDirectory.setPath(p.toString());
                voDirectory.setDirectory(Files.isDirectory(p));
                voDirectory.setDateLastModified(DateTimeUtil.getLocalDateTime(p.toFile().lastModified()));
                voDirectory.setSizeBytes(Files.size(p));
            } catch (IOException e) {
                throw new FileException(EnumError.UNKNOWN.getMessage());
            }

            return voDirectory;
        }).collect(Collectors.toList());
    }
}
