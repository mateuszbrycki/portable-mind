package com.portablemind.card;

import com.portablemind.card.service.CardService;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.project.service.ProjectService;
import com.portablemind.user.UserUtilities;

import com.portablemind.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.portablemind.app.Response;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(CardUrls.Api.CARD)
public class RestCardController {

    @Inject
    CardService cardService;

    @Inject
    ProjectService projectService;

    @Inject
    CardCategoryService cardCategoryService;

    @Inject
    UserService userService;

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<List<Card>> put(@RequestBody CardDTO cardDTO) {

        Integer userId = UserUtilities.getLoggedUserId();
        Integer projectId = cardDTO.getProject();

        Card card = new Card();

        card.setProject(projectService.findProject(projectId));
        card.setCategory(cardCategoryService.findById(cardDTO.getCategory()));
        card.setName(cardDTO.getName());
        card.setDescription(cardDTO.getDescription());
        card.setOwner(userService.findUser(userId));

        Integer id = cardDTO.getId();

        if(id != null) {
            card.setId(id);
            cardService.updateCard(card);
        } else {
            cardService.saveCard(card);
        }

        List<Card> cards = cardService.findAllUserProjectCards(UserUtilities.getLoggedUserId(), projectId);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }

    @RequestMapping(value = CardUrls.Api.CARD_ID, method = RequestMethod.DELETE)
    public ResponseEntity<List<Card>> delete(@PathVariable("cardId") Integer id) {
        Integer userId = UserUtilities.getLoggedUserId();

        if(cardService.getCardOwner(id) != userId) {
            //return new ResponseEntity<Response>(new Response("message", "You don't have permissions."), HttpStatus.FORBIDDEN);
            //TODO mbrycki chujowo, przemyśleć
            return null;
        }
        Integer projectId = cardService.findCard(id).getProject().getId();
        cardService.deleteCardById(id);

        List<Card> cards = cardService.findAllUserProjectCards(UserUtilities.getLoggedUserId(), projectId);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }

    @RequestMapping(value = CardUrls.Api.CARD_ID, method = RequestMethod.GET)
    public ResponseEntity<Object> post(@PathVariable("cardId") Integer id) {

        if(cardService.getCardOwner(id) != UserUtilities.getLoggedUserId()) {
            return new ResponseEntity<Object>(new Response("message", "You don't have permissions."), HttpStatus.FORBIDDEN);
        }

        Card card = cardService.findCard(id);

        return new ResponseEntity<Object>(card, HttpStatus.OK);

    }
}
