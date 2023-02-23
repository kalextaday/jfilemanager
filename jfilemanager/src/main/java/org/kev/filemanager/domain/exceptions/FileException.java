package org.kev.filemanager.domain.exceptions;

import java.io.Serializable;

public class FileException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -7405432357544406448L;
    public FileException(String message){

        super(message);
    }

}
