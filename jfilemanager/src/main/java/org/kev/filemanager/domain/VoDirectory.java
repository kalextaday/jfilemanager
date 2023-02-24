package org.kev.filemanager.domain;

import lombok.*;

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
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoDirectory {

    private String name;
    private String path;
    private boolean isDirectory;
    private long sizeBytes;
    private LocalDateTime dateLastModified;
    private List<VoDirectory> children;

    @Override
    public String toString() {
        return "VoDirectory{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", isDirectory=" + isDirectory +
                ", sizeBytes=" + sizeBytes +
                ", dateLastModified=" + dateLastModified +
                ", children=" + children +
                '}';
    }
}
