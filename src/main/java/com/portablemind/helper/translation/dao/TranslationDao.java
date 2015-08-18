package com.portablemind.helper.translation.dao;

import com.portablemind.helper.translation.Translation;

import java.util.List;

/**
 * Created by Mateusz Brycki on 03/06/2015.
 */
public interface TranslationDao {

    Translation findByName(String name);

    Translation findByNameAndLanguage(String name, Integer languageId);

    List<Translation> getTranslationsByLanguage(Integer languageId);

    List<Translation> getAllTranslationsByName(String name);

}
