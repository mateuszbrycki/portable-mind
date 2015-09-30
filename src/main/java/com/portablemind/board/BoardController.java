package com.portablemind.board;

import com.portablemind.card.service.CardService;
import com.portablemind.cardCategory.CardCategory;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.project.Project;
import com.portablemind.project.service.ProjectService;
import util.UserUtils;

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
        Integer userId = UserUtils.getLoggedUserId();

        /*List<Card> cards = cardService.findAllUserCards(userId);
        model.addAttribute("cards", cards);*/

        List<Project> projects = projectService.findAllUserProjects(userId);
        model.addAttribute("projects", projects);

        List<CardCategory> cardCategories = cardCategoryService.findAllCardCategories();
        model.addAttribute("cardCategories", cardCategories);

        return this.viewPath + "board";
    }
}
