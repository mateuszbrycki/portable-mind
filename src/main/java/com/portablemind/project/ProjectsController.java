package com.portablemind.project;

import com.portablemind.project.service.ProjectService;
import com.portablemind.user.UserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Mateusz Brycki on 24/08/2015.
 */

@Controller
@RequestMapping(value="/projects")
public class ProjectsController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Project>> getUserProjects() {
        List<Project> projects = projectService.findAllUserProjects(UserUtilities.getLoggedUserId());

        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }
}
