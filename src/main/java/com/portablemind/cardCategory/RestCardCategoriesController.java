package com.portablemind.cardCategory;

import com.portablemind.cardCategory.service.CardCategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mateusz Brycki on 24/08/2015.
 */

@RestController
@RequestMapping(CardCategoryUrls.Api.CARD_CATEGORIES)
public class RestCardCategoriesController {

    @Inject
    CardCategoryService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CardCategory>> get() {

        List<CardCategory> categories =  service.findAllCardCategories();

        return new ResponseEntity<List<CardCategory>>(categories, HttpStatus.OK);
    }
}
