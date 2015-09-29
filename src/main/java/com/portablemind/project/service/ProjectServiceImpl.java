package com.portablemind.project.service;

import com.portablemind.filter.FilterManager;
import com.portablemind.project.Project;
import com.portablemind.project.dao.ProjectDao;
import com.portablemind.project.filter.ProjectIdFilter;
import com.portablemind.user.filter.OwnerIdFilter;
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

    @Override
    public void saveProject(Project project) {
        dao.saveProject(project);
    }

    @Override
    public void updateProject(Project project) { dao.updateProject(project); }

    @Override
    public List<Project> findAllProjects() {
        return dao.find(new FilterManager());
    }

    @Override
    public Project findProject(Integer id) {
        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new ProjectIdFilter(id));

        //TODO mbrycki wyjątek
        return dao.find(filterManager).get(0);
    }

    @Override
    public void deleteProjectById(Integer id) {
        dao.deleteProjectById(id);
    }

    @Override
    public List<Project> findAllUserProjects(Integer id) {
        FilterManager filterManager = new FilterManager();
        filterManager.addFilter(new OwnerIdFilter(id));

        return dao.find(filterManager);
    }

    @Override
    public Boolean hasUserProjects(Integer id) { return dao.hasUserProjects(id); }

    @Override
    public Integer getProjectOwner(Integer id) { return dao.getProjectOwner(id); }
}
