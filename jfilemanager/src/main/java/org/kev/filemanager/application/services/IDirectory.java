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
public interface IDirectory {

    VoDirectory getProperties(String path);
    List<VoDirectory> getChildren(File fileDirectory);
    List<VoDirectory> searchFile(String pathStart, String textParameter, String typeSearch);
}
