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

    @RequestMapping(value="/add", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Response> addCard(@RequestBody CardDTO cardDTO) {

        Card card = new Card();

        card.setProject(projectService.findById(cardDTO.getProject()));
        card.setCategory(cardCategoryService.findById(cardDTO.getCategory()));
        card.setDescription(cardDTO.getDescription());

        card.setOwner(UserUtilities.getLoggedUserId());

        Integer id = cardDTO.getId();

        if(id != null) {
            card.setId(id);
            cardService.updateCard(card);
        } else {
            cardService.saveCard(card);
        }

        return new ResponseEntity<Response>(new Response("message", "Card successfully added."), HttpStatus.OK);
    }
    
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Card>> getAllUserCards() {

        Integer userId = UserUtilities.getLoggedUserId();

        List<Card> cards = cardService.findAllUserCards(userId);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }

    @RequestMapping(value="/project/{projectId}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Card>> getAllUserProjectCards(@PathVariable("projectId") Integer projectId) {

        Integer userId = UserUtilities.getLoggedUserId();

        List<Card> cards = cardService.findAllUserProjectCards(userId, projectId);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }


    @RequestMapping(value="/{cardId}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<Response> deleteCard(@PathVariable("cardId") Integer id) {

        if(cardService.getCardOwner(id) != UserUtilities.getLoggedUserId()) {
            return new ResponseEntity<Response>(new Response("message", "You don't have permissions."), HttpStatus.FORBIDDEN);
        }

        cardService.deleteCardById(id);

        return new ResponseEntity<Response>(new Response("message", "Card deleted!"), HttpStatus.OK);
    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Object> editCard(@PathVariable("id") Integer id) {

        if(cardService.getCardOwner(id) != UserUtilities.getLoggedUserId()) {
            return new ResponseEntity<Object>(new Response("message", "You don't have permissions."), HttpStatus.FORBIDDEN);
        }

        Card card = cardService.findById(id);

        return new ResponseEntity<Object>(card, HttpStatus.OK);

    }
}
