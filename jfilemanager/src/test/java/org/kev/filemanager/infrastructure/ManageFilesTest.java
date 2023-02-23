package org.kev.filemanager.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kev.filemanager.domain.VoDirectory;
import org.kev.filemanager.domain.exceptions.FileException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ManageFilesTest {

    @Test
    void testCasePerfect(){
        ManageFiles manageFiles = new ManageFiles();
        VoDirectory voDirectory = manageFiles.getContentDirectory("F:\\DOCUMENTOS/CV");
        Assertions.assertNotNull(voDirectory);
    }

    @Test
    void testExceptionFile() {
        ManageFiles manageFiles = new ManageFiles();

        Exception exception = assertThrows(FileException.class, () -> {
            manageFiles.getContentDirectory("F:\\DOCUMENTOS/CV/certificado_empresa_ruc.pdf");
        });

        String actual = exception.getMessage();
        String expected = "La ruta enviada no es un directorio";

        assertEquals(expected, actual);
    }

    @Test
    void testExceptionNotFound(){
        ManageFiles manageFiles = new ManageFiles();

        Exception exception = assertThrows(FileException.class, () -> {
            manageFiles.getContentDirectory("F:\\DOCUMENTOS/CV1");
        });

        String actual = exception.getMessage();
        String expected = "La ruta enviada no existe";

        assertEquals(expected, actual);
    }
}