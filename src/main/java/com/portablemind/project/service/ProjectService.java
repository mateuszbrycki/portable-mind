package com.portablemind.project.service;

import com.portablemind.project.Project;

import java.util.List;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */
public interface ProjectService {
    void saveProject(Project project);

    void updateProject(Project project);

    List<Project> findAllProjects();

    Project findProject(Integer id);

    void deleteProjectById(Integer id);

    List<Project> findAllUserProjects(Integer id);

    Boolean hasUserProjects(Integer id);

    Integer getProjectOwner(Integer id);
}
