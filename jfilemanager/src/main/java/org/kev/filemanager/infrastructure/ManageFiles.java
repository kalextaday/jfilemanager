package org.kev.filemanager.infrastructure;


import org.kev.filemanager.application.impl.DirectoryService;
import org.kev.filemanager.application.impl.FileService;
import org.kev.filemanager.application.services.IDirectory;
import org.kev.filemanager.application.services.IFile;
import org.kev.filemanager.domain.VoDirectory;

import java.util.List;

/**
 * Created by kevin on 27/12/2022.
 * Clase que se encarga de manejar carpetas y archivos
 * y directorios
 * @author Kevin Taday
 * @version 1.0.0
 * @see VoDirectory
 */
public class ManageFiles {

    private final IDirectory directoryService;
    private final IFile fileService;

    public ManageFiles() {
        this.directoryService = new DirectoryService();
        this.fileService = new FileService();
    }

    /**
     * @param path la ruta del directorio a analizar, Ejm: "F:\\DOCUMENTOS/CV"
     * @return un objeto VoDirectory con la información del directorio y su contenido
     */
    public VoDirectory getContentDirectory(String path) {

        return this.directoryService.getProperties(path);
    }

    public byte[] getBytesOfFile(String path) {

        return this.fileService.getBytesOfFile(path);
    }

    public List<VoDirectory> searchFile(String pathStart, String param, String typeSearch) {

        return this.directoryService.searchFile(pathStart, param, typeSearch);
    }
}
