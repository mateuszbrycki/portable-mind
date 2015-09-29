package com.portablemind.project.dao;

import com.portablemind.app.AbstractDao;
import com.portablemind.filter.FilterManager;
import com.portablemind.filter.hibernate.HibernatePrepareFilters;
import com.portablemind.project.Project;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
/**
 * Created by Mateusz Brycki on 02/05/2015.
 */
@Repository("projectDao")
public class ProjectDaoImpl extends AbstractDao implements ProjectDao {

    @Override
    public void saveProject(Project project) {
        persist(project);
    }

    @Override
    public void updateProject(Project project) { update(project); }

    @SuppressWarnings("unchecked")
    @Override
    public List<Project> find(FilterManager filterManager) {
        Criteria criteria = getSession().createCriteria(Project.class);
        criteria = HibernatePrepareFilters.prepareCriteria(criteria, filterManager);

        List<Project> projects = criteria.list();

        return projects;
    }

    @Override
    public Boolean hasUserProjects(Integer id) {
        Integer count = ((BigInteger)getSession().createSQLQuery("SELECT COUNT(*) FROM project WHERE fk_user_id = :id")
                .setString("id", id.toString())
                .uniqueResult())
                .intValue();

        if(count > 0) {
            return true;
        }

        return false;

    }

    @Override
    public void deleteProjectById(Integer id) {
        Query query = getSession().createSQLQuery("DELETE p.* FROM project p WHERE p.id = :id");
        query.setString("id", id.toString());
        query.executeUpdate();
    }

    @Override
    public Integer getProjectOwner(Integer id) {
        Query query = getSession().createSQLQuery("SELECT p.fk_user_id FROM project p WHERE p.id = :id LIMIT 1");
        query.setString("id", id.toString());

        return (Integer)query.uniqueResult();
    }

}
