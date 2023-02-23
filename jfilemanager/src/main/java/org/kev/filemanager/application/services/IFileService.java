package org.kev.filemanager.application.services;


import org.kev.filemanager.domain.VoDirectory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by kevin on 27/12/2022.
 * Interfaz que se encarga de manejar los archivos
 * y directorios
 * @author Kevin Taday
 * @version 1.0.0
 */
public interface IFileService {

    VoDirectory getProperties(String path) throws IOException;
    List<VoDirectory> getChildren(File fileDirectory);
}
