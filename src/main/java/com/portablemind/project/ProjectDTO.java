package com.portablemind.project;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Mateusz Brycki on 17/08/2015.
 */
public class ProjectDTO {

    private Integer id;
    private String name;
    private Integer owner;
    private String description;
   // private MultipartFile file;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }*/

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }
}
