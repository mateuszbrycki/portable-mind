package com.portablemind.board;

import com.portablemind.card.service.CardService;
import com.portablemind.cardCategory.CardCategory;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.filter.FilterManager;
import com.portablemind.project.Project;
import com.portablemind.project.service.ProjectService;
import com.portablemind.user.UserUtilities;

import com.portablemind.user.filter.OwnerIdFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */

@Controller
@RequestMapping("board/")
public class BoardController {
    private String viewPath = "controller/board/";

    @Inject
    CardService cardService;

    @Inject
    ProjectService projectService;

    @Inject
    CardCategoryService cardCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String getBoard(ModelMap model) {
        Integer userId = UserUtilities.getLoggedUserId();

        /*List<Card> cards = cardService.findAllUserCards(userId);
        model.addAttribute("cards", cards);*/

        List<Project> projects = projectService.findAllUserProjects(userId);
        model.addAttribute("projects", projects);

        List<CardCategory> cardCategories = cardCategoryService.findAllCardCategories();
        model.addAttribute("cardCategories", cardCategories);

        return this.viewPath + "board";
    }
}
