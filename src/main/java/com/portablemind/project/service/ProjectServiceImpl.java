package com.portablemind.project.service;

import com.portablemind.project.Project;
import com.portablemind.project.dao.ProjectDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */
@Service("cardTypeService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Inject
    private ProjectDao dao;

    public void saveProject(Project project) {
        dao.saveProject(project);
    }

    public void updateProject(Project project) { dao.updateProject(project); }

    public List<Project> findAllProjects() {
        return dao.findAllProjects();
    }

    public Project findById(Integer id) { return dao.findById(id); }

    public void deleteProjectById(Integer id) {
        dao.deleteProjectById(id);
    }

    public List<Project> findAllUserProjects(Integer id) {
        return dao.findAllUserProjects(id);
    }

    public Boolean hasUserProjects(Integer id) { return dao.hasUserProjects(id); }

    public Integer getProjectOwner(Integer id) { return dao.getProjectOwner(id); }
}
