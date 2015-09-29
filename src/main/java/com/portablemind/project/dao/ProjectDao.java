package com.portablemind.project.dao;

import com.portablemind.filter.FilterManager;
import com.portablemind.project.Project;

import java.util.List;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */
public interface ProjectDao {
    void saveProject(Project project);

    void updateProject(Project project);

    List<Project> find(FilterManager filterManager);

    void deleteProjectById(Integer id);

    Boolean hasUserProjects(Integer id);

    Integer getProjectOwner(Integer id);
}

