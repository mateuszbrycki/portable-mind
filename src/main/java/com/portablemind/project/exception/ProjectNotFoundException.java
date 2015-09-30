package com.portablemind.project.exception;

/**
 * Created by Mateusz on 30.09.2015.
 */
public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
