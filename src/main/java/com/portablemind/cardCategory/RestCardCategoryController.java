package com.portablemind.cardCategory;

import com.portablemind.app.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CardCategoryUrls.Api.CARD_CATEGORY)
public class RestCardCategoryController {

    @RequestMapping(method = RequestMethod.PUT)
    public  ResponseEntity<Response> put(@RequestBody CardCategoryDTO cardCategory) {

        System.out.println(cardCategory.getFile().getName());

        /*cardCategory.setOwner(UserUtils.getLoggedUserId());
        service.saveCardCategory(cardCategory);*/

        return new ResponseEntity<Response>(new Response("message", "New card category successfully added!"), HttpStatus.OK);
    }
}
