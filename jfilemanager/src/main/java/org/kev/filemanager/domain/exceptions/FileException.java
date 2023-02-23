package org.kev.filemanager.domain.exceptions;

import java.io.Serializable;

public class FileException extends RuntimeException {

    public FileException(String message){

        super(message);
    }

}
