package com.portablemind.cardCategory;

import com.portablemind.cardCategory.service.CardCategoryService;
import com.portablemind.user.UserUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Mateusz Brycki on 24/08/2015.
 */

@Controller
@RequestMapping(value="/cardCategories")
public class CardCategoriesController {

    @Autowired
    CardCategoryService service;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<CardCategory>> getAvailableCategories() {

        List<CardCategory> categories =  service.findAllCardCategories();

        return new ResponseEntity<List<CardCategory>>(categories, HttpStatus.OK);
    }
}
