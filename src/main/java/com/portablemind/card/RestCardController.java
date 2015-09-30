package com.portablemind.card;

import com.portablemind.card.exception.CardNotFoundException;
import com.portablemind.card.service.CardService;
import com.portablemind.cardCategory.exception.CardCategoryNotFoundException;
import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.project.exception.ProjectNotFoundException;
import com.portablemind.project.service.ProjectService;
import com.portablemind.rest.api.RestApiException;
import com.portablemind.rest.api.exceptions.ForbiddenRestApiException;
import com.portablemind.rest.api.exceptions.ResourceNotFoundRestApiException;
import util.UserUtils;

import com.portablemind.user.exception.UserNotFoundException;
import com.portablemind.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        Integer userId = UserUtils.getLoggedUserId();
        Integer projectId = cardDTO.getProject();

        Card card = new Card();

        try {
            card.setProject(projectService.findProject(projectId));
            card.setCategory(cardCategoryService.findById(cardDTO.getCategory()));
            card.setOwner(userService.findUser(userId));
        } catch(RestApiException e) {
            throw new ResourceNotFoundRestApiException()
                    .userMessage(e.getMessage());
        }

        card.setName(cardDTO.getName());
        card.setDescription(cardDTO.getDescription());

        Integer id = cardDTO.getId();

        if(id != null) {
            card.setId(id);
            cardService.updateCard(card);
        } else {
            cardService.saveCard(card);
        }

        List<Card> cards = cardService.findAllUserProjectCards(UserUtils.getLoggedUserId(), projectId);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }

    @RequestMapping(value = CardUrls.Api.CARD_ID, method = RequestMethod.DELETE)
    public ResponseEntity<List<Card>> delete(@PathVariable("cardId") Integer id) {
        Integer userId = UserUtils.getLoggedUserId();

        Card card;
        Integer projectId;
        try {
            card = cardService.findCard(id);
            projectId = card.getProject().getId();
        } catch(RestApiException e) {
            throw new ResourceNotFoundRestApiException()
                    .userMessage(e.getMessage());
        }

        if(card.getOwner().getId() != userId) {
            throw new ForbiddenRestApiException()
                    .userMessage("You don't have permissions.");
        }

        cardService.deleteCardById(id);

        List<Card> cards = cardService.findAllUserProjectCards(UserUtils.getLoggedUserId(), projectId);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }

    @RequestMapping(value = CardUrls.Api.CARD_ID, method = RequestMethod.GET)
    public ResponseEntity<Object> post(@PathVariable("cardId") Integer id) {

        Card card;
        try {
            card = cardService.findCard(id);
        } catch(CardNotFoundException e) {
            throw new ResourceNotFoundRestApiException()
                    .userMessage(e.getMessage());
        }

        if(card.getOwner().getId() != UserUtils.getLoggedUserId()) {
            throw new ForbiddenRestApiException()
                    .userMessage("You don't have permissions.");
        }

        return new ResponseEntity<Object>(card, HttpStatus.OK);

    }
}
