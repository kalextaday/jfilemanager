package org.kev.filemanager.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kev.filemanager.infrastructure.ManageFiles;

import static org.junit.jupiter.api.Assertions.*;

class VoDirectoryTest {

    @Test
    void test() {
        VoDirectory voDirectory = new VoDirectory();
        voDirectory.setName("TEST");
        voDirectory.setPath("F:\\DOCUMENTOS/CV/TEST");

        Assertions.assertEquals("TEST", voDirectory.getName());
    }
}