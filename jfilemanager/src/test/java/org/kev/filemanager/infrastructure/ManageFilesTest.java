package org.kev.filemanager.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManageFilesTest {

    @Test
    void test() {
        ManageFiles manageFiles = new ManageFiles();
        Assertions.assertNotNull(manageFiles.getContentDirectory("F:\\DOCUMENTOS/CV"));
    }
}