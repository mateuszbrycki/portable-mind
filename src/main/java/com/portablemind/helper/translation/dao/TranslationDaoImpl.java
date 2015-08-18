package com.portablemind.helper.translation.dao;

import com.portablemind.app.AbstractDao;
import com.portablemind.helper.translation.Translation;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Brycki on 03/06/2015.
 */
public class TranslationDaoImpl extends AbstractDao implements TranslationDao {

  /*  @Autowired
    private LanguageService languageService;*/

    @Override
    public Translation findByName(String name) {
        Query query = getSession().createSQLQuery("SELECT t.* FROM translation t WHERE t.name = :name AND t.fk_language_id = 1 LIMIT 1");
        query.setString("name", name);
        List<Object[]> result = query.list();

        return this.mapTranslationObject(result.get(0));
    }

    @Override
    public Translation findByNameAndLanguage(String name, Integer languageId) {
        Query query = getSession().createSQLQuery("SELECT t.* FROM translation t WHERE t.name = :name AND t.fk_language_id = :language LIMIT 1");
        query.setString("name", name);
        query.setString("language", languageId.toString());
        List<Object[]> result = query.list();

        return this.mapTranslationObject(result.get(0));
    }

    @Override
    public List<Translation> getTranslationsByLanguage(Integer languageId) {
        Query query = getSession().createSQLQuery("SELECT t.* FROM translation t WHERE t.fk_language_id = :language");
        query.setString("language", languageId.toString());
        List<Object[]> result = (List<Object[]>) query.list();

        List<Translation> translations = new ArrayList<Translation>();
        for(Object[] cardType : result) {
            translations.add(this.mapTranslationObject(cardType));
        }

        return translations;
    }

    @Override
    public List<Translation> getAllTranslationsByName(String name) {
        Query query = getSession().createSQLQuery("SELECT t.* FROM translation t WHERE t.name = :name");
        query.setString("name", name);
        List<Object[]> result = (List<Object[]>) query.list();

        List<Translation> translations = new ArrayList<Translation>();
        for(Object[] cardType : result) {
            translations.add(this.mapTranslationObject(cardType));
        }

        return translations;
    }

    private Translation mapTranslationObject(Object[] translationObject) {

        if(translationObject == null) {
            return null;
        }

        Translation translation = new Translation();
        translation.setId((Integer) translationObject[0]);
        translation.setName((String) translationObject[1]);
        translation.setValue((String) translationObject[2]);
       // translation.setLanguage(languageService.findById((Integer) translationObject[3]));

        return translation;
    }
}
