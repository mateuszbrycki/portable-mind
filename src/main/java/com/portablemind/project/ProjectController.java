package com.portablemind.project;

import com.portablemind.card.Card;
import com.portablemind.card.service.CardService;
import com.portablemind.cardCategory.CardCategory;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.project.service.ProjectService;
import util.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping(ProjectUrls.PROJECT)
public class ProjectController {
    private String viewPath = "controller/project/";

    @Inject
    ProjectService projectService;

    @Inject
    CardService cardService;

    @Inject
    CardCategoryService cardCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String get(@PathVariable("projectId") Integer projectId, ModelMap model) {
        Integer userId = UserUtils.getLoggedUserId();

        Project project = projectService.findProject(projectId);
        model.addAttribute("project", project);

        List<Card> cards = cardService.findAllProjectCards(projectId);
        model.addAttribute("cards", cards);


        List<Project> projects = projectService.findAllUserProjects(userId);
        model.addAttribute("projects", projects);

        List<CardCategory> cardCategories = cardCategoryService.findAllCardCategories();
        model.addAttribute("cardCategories", cardCategories);

        return this.viewPath + "list";
    }


}
