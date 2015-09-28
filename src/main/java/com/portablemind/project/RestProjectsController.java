package com.portablemind.project;

import com.portablemind.project.service.ProjectService;
import com.portablemind.user.UserUtilities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mateusz Brycki on 24/08/2015.
 */

@RestController
@RequestMapping(ProjectUrls.Api.PROJECTS)
public class RestProjectsController {

    @Inject
    ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Project>> get() {
        List<Project> projects = projectService.findAllUserProjects(UserUtilities.getLoggedUserId());

        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }
}
