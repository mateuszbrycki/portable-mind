package com.portablemind.card;

import com.portablemind.card.service.CardService;
import com.portablemind.filter.FilterManager;
import com.portablemind.user.UserUtilities;

import com.portablemind.user.filter.OwnerIdFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(CardUrls.Api.CARDS)
public class RestCardsController {

    @Inject
    CardService cardService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Card>> get() {

        Integer userId = UserUtilities.getLoggedUserId();

        List<Card> cards = cardService.findAllUserCards(userId);

        return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
    }
}
