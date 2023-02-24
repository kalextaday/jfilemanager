package org.kev.filemanager.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kev.filemanager.infrastructure.ManageFiles;

import static org.junit.jupiter.api.Assertions.*;

class VoDirectoryTest {

    @Test
    void testFields() {
        VoDirectory voDirectory = VoDirectory.builder()
                .name("TEST")
                .path("F:\\DOCUMENTOS/CV/TEST")
                .sizeBytes(1000L)
                .isDirectory(true)
                .children(null)
                .dateLastModified(null)
                .build();

        Assertions.assertEquals("TEST", voDirectory.getName());
        Assertions.assertEquals("F:\\DOCUMENTOS/CV/TEST", voDirectory.getPath());
        Assertions.assertEquals(1000L, voDirectory.getSizeBytes());
        Assertions.assertEquals(true, voDirectory.isDirectory());
        Assertions.assertNull(voDirectory.getChildren());
        Assertions.assertNull(voDirectory.getDateLastModified());
    }
}