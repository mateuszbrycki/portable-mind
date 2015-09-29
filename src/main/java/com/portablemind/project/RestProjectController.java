package com.portablemind.project;

import com.portablemind.app.Response;
import com.portablemind.card.Card;
import com.portablemind.card.service.CardService;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.project.service.ProjectService;
import com.portablemind.user.UserSecurity;
import com.portablemind.user.UserUtilities;

import com.portablemind.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */

@RestController
@RequestMapping(ProjectUrls.Api.PROJECT)
public class RestProjectController {

    @Inject
    ProjectService projectService;

    @Inject
    CardService cardService;

    @Inject
    CardCategoryService cardCategoryService;

    @Inject
    UserService userService;


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<List<Project>> addProject(@RequestBody ProjectDTO projectDTO) {
        Integer userId = UserUtilities.getLoggedUserId();

        Project project = new Project();

        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setOwner(userService.findUser(userId));

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



    @RequestMapping(value=ProjectUrls.Api.PROJECT_ID, method = RequestMethod.DELETE)
    public ResponseEntity<List<Project>> delete(@PathVariable("projectId") Integer projectId) {
        Integer userId = UserUtilities.getLoggedUserId();
        if(projectService.findProject(projectId).getOwner().getId() != userId) {
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
    
    @RequestMapping(value=ProjectUrls.Api.PROJECT_ID, method = RequestMethod.GET)
    public ResponseEntity<Object> get(@PathVariable("projectId") Integer projectId) {

        if (projectService.getProjectOwner(projectId) != UserUtilities.getLoggedUserId()) {
            return new ResponseEntity<Object>(new Response("message", "You don't have permissions."), HttpStatus.FORBIDDEN);
        }

        Project project = projectService.findProject(projectId);

        return new ResponseEntity<Object>(project, HttpStatus.OK);

    }

    @RequestMapping(value=ProjectUrls.Api.PROJECT_ID_CARDS, method = RequestMethod.GET)
    public ResponseEntity<List<Card>> getAllUserProjectCards(@PathVariable("projectId") Integer projectId,
                                                             @RequestParam(value = "category", required = false) Integer cardCategoryId) {
        List<Card> cards;
        if(cardCategoryId != null) {
            cards = cardService.findAllUserProjectCards(UserUtilities.getLoggedUserId(), projectId, cardCategoryId);
        } else {
            cards = cardService.findAllUserProjectCards(UserUtilities.getLoggedUserId(), projectId);
        }


        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }

}
