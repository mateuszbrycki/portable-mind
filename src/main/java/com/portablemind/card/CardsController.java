package com.portablemind.card;

import com.portablemind.card.service.CardService;
import com.portablemind.user.UserUtilities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/cards")
public class CardsController {

    @Inject
    CardService cardService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Card>> getAllUserCards() {

        Integer userId = UserUtilities.getLoggedUserId();

        List<Card> cards = cardService.findAllUserCards(userId);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }
}
