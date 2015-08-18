package com.portablemind.board;

import com.portablemind.card.Card;
import com.portablemind.card.service.CardService;
import com.portablemind.cardCategory.CardCategory;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.project.Project;
import com.portablemind.project.service.ProjectService;
import com.portablemind.user.UserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mateusz Brycki on 28/04/2015.
 */

@Controller
@RequestMapping("board/")
public class BoardController {
    private String viewPath = "controller/board/";

    @Autowired
    CardService cardService;

    @Autowired
    ProjectService projectService;

    @Autowired
    CardCategoryService cardCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String mainAction(ModelMap model) {
        Integer userId = UserUtilities.getLoggedUserId();

        /*List<Card> cards = cardService.findAllUserCards(userId);
        model.addAttribute("cards", cards);*/

        List<Project> projects = projectService.findAllUserProjects(userId);
        model.addAttribute("projects", projects);

        List<CardCategory> cardCategories = cardCategoryService.findAllUserCardCategories(userId);
        model.addAttribute("cardCategories", cardCategories);

        return this.viewPath + "board";
    }
}
