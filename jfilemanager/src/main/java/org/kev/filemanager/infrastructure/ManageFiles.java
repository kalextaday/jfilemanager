package org.kev.filemanager.infrastructure;


import org.kev.filemanager.application.impl.FileService;
import org.kev.filemanager.domain.VoDirectory;

/**
 * Created by kevin on 27/12/2022.
 * Clase que se encarga de manejar los archivos
 * y directorios
 * @author Kevin Taday
 * @version 1.0.0
 * @see VoDirectory
 */
public class ManageFiles {

    /**
     * @param path la ruta del directorio a analizar, Ejm: "F:\\DOCUMENTOS/CV"
     * @return un objeto VoDirectory con la información del directorio y su contenido
     */
    public VoDirectory getContentDirectory(String path) {

        return new FileService().getProperties(path);
    }
}
