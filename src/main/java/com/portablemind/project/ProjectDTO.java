package com.portablemind.project;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Mateusz Brycki on 17/08/2015.
 */
public class ProjectDTO extends Project {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
