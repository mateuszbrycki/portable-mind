package com.portablemind.project.dao;

import com.portablemind.app.AbstractDao;
import com.portablemind.project.Project;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Mateusz Brycki on 02/05/2015.
 */
@Repository("cardTypeDao")
public class ProjectDaoImpl extends AbstractDao implements ProjectDao {

    public void saveProject(Project project) {
        persist(project);
    }

    public void updateProject(Project project) { update(project); }

    public List<Project> findAllProjects() {
        Criteria criteria = getSession().createCriteria(Project.class);
        return (List<Project>) criteria.list();
    }

    public Project findById(Integer id) {
        Query query = getSession().createSQLQuery("SELECT p.* FROM project p WHERE p.id = :id LIMIT 1");
        query.setString("id", id.toString());
        List<Object[]> result = query.list();

        return this.mapProjectObject(result.get(0));

    }

    public List<Project> findAllUserProjects(Integer id) {
        Query query = getSession().createSQLQuery("SELECT p.* FROM project p WHERE p.fk_user_id = :id");
        query.setString("id", id.toString());
        List<Object[]> result = (List<Object[]>) query.list();

        List<Project> projects = new ArrayList<Project>();
        for(Object[] cardType : result) {
            projects.add(this.mapProjectObject(cardType));
        }

        return projects;
    }

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

    public void deleteProjectById(Integer id) {
        Query query = getSession().createSQLQuery("DELETE p.* FROM project p WHERE p.id = :id");
        query.setString("id", id.toString());
        query.executeUpdate();
    }

    public Integer getProjectOwner(Integer id) {
        Query query = getSession().createSQLQuery("SELECT p.fk_user_id FROM project p WHERE p.id = :id LIMIT 1");
        query.setString("id", id.toString());

        return (Integer)query.uniqueResult();
    }

    private Project mapProjectObject(Object[] projectObject) {

        if(projectObject == null) {
            return null;
        }

        Project project = new Project();
        project.setId((Integer)projectObject[0]);
        project.setName((String) projectObject[1]);
        project.setDescription((String) projectObject[2]);
        project.setOwner((Integer) projectObject[3]);

        return project;
    }
}
