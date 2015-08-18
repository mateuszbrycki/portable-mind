package com.portablemind.helper.translation.service;

import com.portablemind.helper.translation.Translation;
import com.portablemind.helper.translation.dao.TranslationDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Mateusz Brycki on 03/06/2015.
 */
public class TranslationServiceImpl implements TranslationService {

    @Autowired
    private TranslationDao translationDao;


    @Override
    public Translation findByName(String name) {
        return translationDao.findByName(name);
    }

    @Override
    public Translation findByNameAndLanguage(String name, Integer languageId) {
        return translationDao.findByNameAndLanguage(name, languageId);
    }

    @Override
    public List<Translation> getTranslationsByLanguage(Integer languageId) {
        return translationDao.getTranslationsByLanguage(languageId);
    }

    @Override
    public List<Translation> getAllTranslationsByName(String name) {
        return translationDao.getAllTranslationsByName(name);
    }
}
