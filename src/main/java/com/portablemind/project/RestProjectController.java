package com.portablemind.project;

import com.portablemind.card.Card;
import com.portablemind.card.service.CardService;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.project.exception.ProjectNotFoundException;
import com.portablemind.project.service.ProjectService;
import com.portablemind.rest.api.exceptions.ForbiddenRestApiException;
import com.portablemind.rest.api.exceptions.ResourceNotFoundRestApiException;
import com.portablemind.user.UserSecurity;
import util.UserUtils;

import com.portablemind.user.exception.UserNotFoundException;
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
        Integer userId = UserUtils.getLoggedUserId();

        Project project = new Project();

        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());

        try {
            project.setOwner(userService.findUser(userId));
        } catch (UserNotFoundException e) {
            throw new ResourceNotFoundRestApiException()
                    .userMessage(e.getMessage());
        }

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

        //TODO mbrycki w przypadku listowania projektów "on scroll" powinna być zwracana "aktualna pozycja"
        List<Project> projects = projectService.findAllUserProjects(userId);

        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }



    @RequestMapping(value=ProjectUrls.Api.PROJECT_ID, method = RequestMethod.DELETE)
    public ResponseEntity<List<Project>> delete(@PathVariable("projectId") Integer projectId) {
        Integer userId = UserUtils.getLoggedUserId();

        if(projectService.findProject(projectId).getOwner().getId() != userId) {
            throw new ForbiddenRestApiException()
                    .userMessage("You don't have permissions.");
        }

        projectService.deleteProjectById(projectId);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserSecurity currentUser = (UserSecurity)auth.getPrincipal();
        currentUser.setHasUserProjects(projectService.hasUserProjects(userId));

        //TODO mbrycki w przypadku listowania projektów "on scroll" powinna być zwracana "aktualna pozycja" - filtry i strona
        List<Project> projects = projectService.findAllUserProjects(userId);

        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);

    }
    
    @RequestMapping(value=ProjectUrls.Api.PROJECT_ID, method = RequestMethod.GET)
    public ResponseEntity<Object> get(@PathVariable("projectId") Integer projectId) {

        Project project;
        try {
            project = projectService.findProject(projectId);
        } catch (ProjectNotFoundException e) {
            throw new ResourceNotFoundRestApiException()
                    .userMessage(e.getMessage());
        }

        if (project.getOwner().getId() != UserUtils.getLoggedUserId()) {
            throw new ForbiddenRestApiException()
                    .userMessage("You don't have permissions.");
        }

        return new ResponseEntity<Object>(project, HttpStatus.OK);

    }

    @RequestMapping(value=ProjectUrls.Api.PROJECT_ID_CARDS, method = RequestMethod.GET)
    public ResponseEntity<List<Card>> getAllUserProjectCards(@PathVariable("projectId") Integer projectId,
                                                             @RequestParam(value = "category", required = false) Integer cardCategoryId,
                                                             @RequestParam(value = "page", required = false) Integer page) {

        List<Card> cards = cardService.findAllUserProjectCards(UserUtils.getLoggedUserId(), projectId, cardCategoryId, page);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }

}
