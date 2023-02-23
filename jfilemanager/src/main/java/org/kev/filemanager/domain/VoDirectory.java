package org.kev.filemanager.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kevin on 27/12/2022.
 * Estructura que almacena la información de los archivos
 * y directorios
 * @author Kevin Taday
 * @version 1.0.0
 * @see LocalDateTime
 */
public class VoDirectory {

    private String name;
    private String path;
    private boolean isDirectory;
    private long sizeBytes;
    private LocalDateTime dateLastModified;
    private List<VoDirectory> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public List<VoDirectory> getChildren() {
        return children;
    }

    public void setChildren(List<VoDirectory> children) {
        this.children = children;
    }

    public long getSizeBytes() {
        return sizeBytes;
    }

    public void setSizeBytes(long sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    public LocalDateTime getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(LocalDateTime dateLastModified) {
        this.dateLastModified = dateLastModified;
    }
}
