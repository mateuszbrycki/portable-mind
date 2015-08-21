package com.portablemind.project;

import com.portablemind.app.Response;
import com.portablemind.card.Card;
import com.portablemind.card.service.CardService;
import com.portablemind.cardCategory.CardCategory;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.project.service.ProjectService;
import com.portablemind.user.UserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @RequestMapping(value="/add", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Response> addProject(@RequestBody Project project) {
        project.setOwner(UserUtilities.getLoggedUserId());

        projectService.saveProject(project);

        return new ResponseEntity<Response>(new Response("message", "New project successfully added!"), HttpStatus.OK);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Project>> getUserProjects() {
        List<Project> projects = projectService.findAllUserProjects(UserUtilities.getLoggedUserId());

        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }

    @RequestMapping(value="/{projectId}", method = RequestMethod.GET)
    public String listUserProjects(@PathVariable("projectId") Integer projectId, ModelMap model) {
        Integer userId = UserUtilities.getLoggedUserId();

        Project project = projectService.findById(projectId);
        model.addAttribute("project", project);

        List<Card> cards = cardService.findAllProjectCards(projectId);
        model.addAttribute("cards", cards);


        List<Project> projects = projectService.findAllUserProjects(userId);
        model.addAttribute("projects", projects);

        List<CardCategory> cardCategories = cardCategoryService.findAllUserCardCategories(userId);
        model.addAttribute("cardCategories", cardCategories);

        return this.viewPath + "list";

    }

    @RequestMapping(value="/{projectId}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<Response> deleteAction(@PathVariable("projectId") Integer projectId) {

        if(projectService.findById(projectId).getOwner() != UserUtilities.getLoggedUserId()) {
            return new ResponseEntity<Response>(new Response("message", "You don't have permissions."), HttpStatus.FORBIDDEN);

        }

        projectService.deleteProjectById(projectId);

        return new ResponseEntity<Response>(new Response("message", "Project deleted!"), HttpStatus.OK);
    }

}
