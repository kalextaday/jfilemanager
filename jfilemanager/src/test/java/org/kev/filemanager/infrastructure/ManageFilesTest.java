package org.kev.filemanager.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kev.filemanager.domain.VoDirectory;
import org.kev.filemanager.domain.exceptions.EnumError;
import org.kev.filemanager.domain.exceptions.FileException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManageFilesTest {

    private final String PATH_DIRECTORY = "F:\\DOCUMENTOS/CV";
    private final String PATH_FILE = "F:\\DOCUMENTOS/CV/Referencia_Laboral.pdf";
    private final String PATH_FILE_NOT_EXISTS = "F:\\DOCUMENTOS/CV/file_not_exists.pdf";
    private final String DIRECTORY_NOT_EXISTS = "F:\\DOCUMENTOS/directory_not_exists";
    private final String PATH_NOT_DIRECTORY = "F:\\DOCUMENTOS/CV/Referencia_Laboral.pdf";
    private final String FILE_NOT_EXISTS = "file_not_exists.pdf";
    private final String FILE_EXISTS = "Referencia_Laboral.pdf";
    @Test
    void testDirectoryPerfect(){
        ManageFiles manageFiles = new ManageFiles();
        VoDirectory voDirectory = manageFiles.getContentDirectory(PATH_DIRECTORY);
        Assertions.assertNotNull(voDirectory);
    }

    @Test
    void testExceptionFile() {
        ManageFiles manageFiles = new ManageFiles();

        Exception exception = assertThrows(FileException.class, () -> {
            manageFiles.getContentDirectory(PATH_FILE);
        });

        String actualError = exception.getMessage();

        Assertions.assertEquals(EnumError.PATH_IS_NOT_DIRECTORY.getMessage(), actualError);
    }

    @Test
    void testExceptionNotFound(){
        ManageFiles manageFiles = new ManageFiles();

        Exception exception = assertThrows(FileException.class, () -> {
            manageFiles.getContentDirectory(DIRECTORY_NOT_EXISTS);
        });

        String actualError = exception.getMessage();

        Assertions.assertEquals(EnumError.PATH_NOT_FOUND.getMessage(), actualError);
    }

    @Test
    void testFilePerfect(){
        ManageFiles manageFiles = new ManageFiles();
        byte[] content = manageFiles.getBytesOfFile(PATH_FILE);
        Assertions.assertNotNull(content);
    }

    @Test
    void testFileNotExists(){
        ManageFiles manageFiles = new ManageFiles();

        Exception exception = assertThrows(FileException.class, () -> {
            manageFiles.getBytesOfFile(PATH_FILE_NOT_EXISTS);
        });

        String actualError = exception.getMessage();

        Assertions.assertEquals(EnumError.FILE_NOT_EXISTS.getMessage(), actualError);
    }

    @Test
    void testSearchFileFullName_Perfect(){
        ManageFiles manageFiles = new ManageFiles();
        String typeSearch = "full";

        List<VoDirectory> result = manageFiles.searchFile(PATH_DIRECTORY, FILE_EXISTS, typeSearch);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void testSearchFileFullName_FileDontExists(){
        ManageFiles manageFiles = new ManageFiles();
        String typeSearch = "full";
        List<VoDirectory> result = manageFiles.searchFile(PATH_DIRECTORY, FILE_NOT_EXISTS, typeSearch);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void testSearchFileFullName_DirectoryDontExists(){
        ManageFiles manageFiles = new ManageFiles();
        String typeSearch = "full";
        Exception exception = assertThrows(FileException.class, () -> {
            manageFiles.searchFile(DIRECTORY_NOT_EXISTS, FILE_NOT_EXISTS, typeSearch);
        });

        String actualError = exception.getMessage();

        Assertions.assertEquals(EnumError.PATH_NOT_FOUND.getMessage(), actualError);
    }

    @Test
    void testSearchFilePartialName_Perfect(){
        ManageFiles manageFiles = new ManageFiles();
        String typeSearch = "contains";

        List<VoDirectory> result = manageFiles.searchFile(PATH_DIRECTORY, "D01", typeSearch);

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size()>1);
    }

    @Test
    void testSearchFilePartialName_FileDontExists(){
        ManageFiles manageFiles = new ManageFiles();
        String typeSearch = "contains";
        List<VoDirectory> result = manageFiles.searchFile(PATH_DIRECTORY, FILE_NOT_EXISTS, typeSearch);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void testSearchFilePartialName_DirectoryDontExists(){
        ManageFiles manageFiles = new ManageFiles();
        String typeSearch = "contains";
        Exception exception = assertThrows(FileException.class, () -> {
            manageFiles.searchFile(DIRECTORY_NOT_EXISTS, FILE_NOT_EXISTS, typeSearch);
        });

        String actualError = exception.getMessage();

        Assertions.assertEquals(EnumError.PATH_NOT_FOUND.getMessage(), actualError);
    }

    @Test
    void testSearchFileDefault_Perfect(){
        ManageFiles manageFiles = new ManageFiles();
        String typeSearch = "full";

        List<VoDirectory> result = manageFiles.searchFile(PATH_DIRECTORY, FILE_EXISTS, typeSearch);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void testSearchFileSize_Perfect(){
        ManageFiles manageFiles = new ManageFiles();
        String typeSearch = "size";
        String parameter = "0:1024000";

        List<VoDirectory> result = manageFiles.searchFile(PATH_DIRECTORY, parameter, typeSearch);

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size()>0);
    }

    @Test
    void testSearchFileSize_MinMaxInvalid(){
        ManageFiles manageFiles = new ManageFiles();
        String typeSearch = "size";

        String parameter = "-1:1024000";
        Exception exception = assertThrows(FileException.class, () -> {
            manageFiles.searchFile(PATH_DIRECTORY, parameter, typeSearch);
        });
        String actualError = exception.getMessage();
        Assertions.assertEquals(EnumError.PARAM_SEARCH_SIZE.getMessage(), actualError);


        String parameterTwo = "1024000:1";
        exception = assertThrows(FileException.class, () -> {
            manageFiles.searchFile(PATH_DIRECTORY, parameterTwo, typeSearch);
        });
        actualError = exception.getMessage();
        Assertions.assertEquals(EnumError.PARAM_SEARCH_SIZE.getMessage(), actualError);

        String parameterThree = "102400.2:1";
        exception = assertThrows(FileException.class, () -> {
            manageFiles.searchFile(PATH_DIRECTORY, parameterThree, typeSearch);
        });
        actualError = exception.getMessage();
        Assertions.assertEquals(EnumError.PARAM_VALUE_WITH_DECIMAL.getMessage(), actualError);
    }

    @Test
    void testSearchFileLastModified_Perfect(){
        ManageFiles manageFiles = new ManageFiles();
        String typeSearch = "last_modified";
        String parameter = "10";

        List<VoDirectory> result = manageFiles.searchFile(PATH_DIRECTORY, parameter, typeSearch);

        Assertions.assertNotNull(result);
    }
}