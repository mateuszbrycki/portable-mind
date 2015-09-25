package com.portablemind.project;

import com.portablemind.app.Response;
import com.portablemind.card.Card;
import com.portablemind.card.service.CardService;
import com.portablemind.cardCategory.CardCategory;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.project.service.ProjectService;
import com.portablemind.user.UserSecurity;
import com.portablemind.user.UserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */


@Controller
@RequestMapping(value="/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    CardService cardService;

    @Autowired
    CardCategoryService cardCategoryService;

    private String viewPath = "controller/project/";


    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<List<Project>> addProject(@RequestBody ProjectDTO projectDTO) {
        Integer userId = UserUtilities.getLoggedUserId();

        Project project = new Project();

        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setOwner(userId);

        Integer id = projectDTO.getId();

        if(id != null) {
            project.setId(id);
            projectService.updateProject(project);
        } else {
            projectService.saveProject(project);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UserSecurity currentUser = (UserSecurity)auth.getPrincipal();
            currentUser.setHasUserProjects(true);
        }

        List<Project> projects = projectService.findAllUserProjects(userId);

        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }

    @RequestMapping(value="/{projectId}", method = RequestMethod.GET)
    public String getProject(@PathVariable("projectId") Integer projectId, ModelMap model) {
        Integer userId = UserUtilities.getLoggedUserId();

        Project project = projectService.findById(projectId);
        model.addAttribute("project", project);

        List<Card> cards = cardService.findAllProjectCards(projectId);
        model.addAttribute("cards", cards);


        List<Project> projects = projectService.findAllUserProjects(userId);
        model.addAttribute("projects", projects);

        List<CardCategory> cardCategories = cardCategoryService.findAllCardCategories();
        model.addAttribute("cardCategories", cardCategories);

        return this.viewPath + "list";

    }

    @RequestMapping(value="/{projectId}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<List<Project>> deleteProject(@PathVariable("projectId") Integer projectId) {
        Integer userId = UserUtilities.getLoggedUserId();
        if(projectService.findById(projectId).getOwner() != userId) {
            //return new ResponseEntity<Response>(new Response("message", "You don't have permissions."), HttpStatus.FORBIDDEN);
            //TODO mbrycki chujowo, przemyśleć
            return null;
        }

        projectService.deleteProjectById(projectId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserSecurity currentUser = (UserSecurity)auth.getPrincipal();
        currentUser.setHasUserProjects(projectService.hasUserProjects(userId));

        List<Project> projects = projectService.findAllUserProjects(userId);

        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);

    }
    
    @RequestMapping(value="/{projectId}/entity", method = RequestMethod.GET)
    public ResponseEntity<Object> getProjectEntity(@PathVariable("projectId") Integer projectId) {

        if(projectService.getProjectOwner(projectId) != UserUtilities.getLoggedUserId()) {
            return new ResponseEntity<Object>(new Response("message", "You don't have permissions."), HttpStatus.FORBIDDEN);
        }
        
        Project project = projectService.findById(projectId);

        return new ResponseEntity<Object>(project, HttpStatus.OK);
        
    }
    


    @RequestMapping(value="/{projectId}/cards", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Card>> getAllUserProjectCards(@PathVariable("projectId") Integer projectId) {

        Integer userId = UserUtilities.getLoggedUserId();

        List<Card> cards = cardService.findAllUserProjectCards(userId, projectId);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }

}
