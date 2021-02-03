package com.jay.apps.dictionary.services;

import com.jay.apps.dictionary.models.Word;

import java.util.List;

public interface IWordService {
    public Word save(Word word);
    public Word update(Word word);
    public List<Word> getAll();
    public Boolean delete (int id);
    public List<Word> getMatching(String str);

}
