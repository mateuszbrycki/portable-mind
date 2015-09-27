package com.portablemind.cardCategory;

import com.portablemind.app.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/cardCategory")
public class CardCategoryController {

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Response> addCardCategory(@RequestBody CardCategoryDTO cardCategory) {

        System.out.println(cardCategory.getFile().getName());

        /*cardCategory.setOwner(UserUtilities.getLoggedUserId());
        service.saveCardCategory(cardCategory);*/

        return new ResponseEntity<Response>(new Response("message", "New card category successfully added!"), HttpStatus.OK);
    }
}
