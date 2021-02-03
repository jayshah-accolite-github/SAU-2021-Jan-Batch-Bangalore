package com.jay.apps.dictionary.services.impl;

import com.jay.apps.dictionary.dao.IWordDao;
import com.jay.apps.dictionary.models.Word;
import com.jay.apps.dictionary.services.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class WordService implements IWordService {

    @Autowired
    IWordDao iWordDao;

    @Override
    public Word save(Word word) {
        if(word!=null)
        {
            word.setCreationTm(new Date());
            word.setLastModifiedTm(new Date());
        }

        return iWordDao.save(word);
    }

    @Override
    public Word update(Word word) {
        if(word!=null)
        {
//            word.setCreationTm(new Date());
            word.setLastModifiedTm(new Date());
        }

        return iWordDao.update(word);
    }

    @Override
    public List<Word> getAll() {
        return iWordDao.getAll();
    }
    @Override
    public List<Word> getMatching(String str) {
        return iWordDao.getMatchingWords(str);
    }
    @Override
    public Boolean delete(int id) {
        int rowsAffected=iWordDao.delete(id);
        if(rowsAffected==1) {
            return true;
        }
        return false;
    }

}
