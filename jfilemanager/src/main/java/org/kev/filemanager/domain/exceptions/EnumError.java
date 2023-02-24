package org.kev.filemanager.domain.exceptions;

import lombok.Getter;

@Getter
public enum EnumError {

    PARAM_VALUE_WITH_DECIMAL("The value sent is not valid, the value must be a number without decimals"),
    PARAM_SEARCH_SIZE("Minimum size or maximum size are not valid, values must be greater than 0 and minimum size must be less than maximum size"),
    UNKNOWN("Error unknown"),
    FILE_NOT_EXISTS("File does not exists"),
    PATH_IS_NOT_DIRECTORY("The path sent is not a directory"),
    PATH_NOT_FOUND("The path sent does not exist");

    private String message;

    EnumError(String message) {
        this.message = message;
    }
}
