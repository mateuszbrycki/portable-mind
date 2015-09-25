package com.portablemind.card;

/**
 * Created by Mateusz Brycki on 02/05/2015.
 */

import com.portablemind.card.service.CardService;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.project.service.ProjectService;
import com.portablemind.user.UserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.portablemind.app.Response;

import java.util.List;

@Controller
@RequestMapping("/card")
public class CardController {
    private String viewPath = "controller/card/";

    @Autowired
    CardService cardService;

    @Autowired
    ProjectService projectService;

    @Autowired
    CardCategoryService cardCategoryService;

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<List<Card>> addCard(@RequestBody CardDTO cardDTO) {

        Integer userId = UserUtilities.getLoggedUserId();
        Integer projectId = cardDTO.getProject();

        Card card = new Card();

        card.setProject(projectService.findById(projectId));
        card.setCategory(cardCategoryService.findById(cardDTO.getCategory()));
        card.setName(cardDTO.getName());
        card.setDescription(cardDTO.getDescription());
        card.setOwner(userId);

        Integer id = cardDTO.getId();

        if(id != null) {
            card.setId(id);
            cardService.updateCard(card);
        } else {
            cardService.saveCard(card);
        }

        List<Card> cards = cardService.findAllUserProjectCards(userId, projectId);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }

    @RequestMapping(value="/{cardId}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<List<Card>> deleteCard(@PathVariable("cardId") Integer id) {
        Integer userId = UserUtilities.getLoggedUserId();

        if(cardService.getCardOwner(id) != userId) {
            //return new ResponseEntity<Response>(new Response("message", "You don't have permissions."), HttpStatus.FORBIDDEN);
            //TODO mbrycki chujowo, przemyśleć
            return null;
        }
        Integer projectId = cardService.findById(id).getProject().getId();
        cardService.deleteCardById(id);

        List<Card> cards = cardService.findAllUserProjectCards(userId, projectId);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Object> editCard(@PathVariable("id") Integer id) {

        if(cardService.getCardOwner(id) != UserUtilities.getLoggedUserId()) {
            return new ResponseEntity<Object>(new Response("message", "You don't have permissions."), HttpStatus.FORBIDDEN);
        }

        Card card = cardService.findById(id);

        return new ResponseEntity<Object>(card, HttpStatus.OK);

    }
}
