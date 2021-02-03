package com.jay.apps.dictionary.dao;

import com.jay.apps.dictionary.models.Word;

import java.util.List;

public interface IWordDao {
    public Word save(Word word);
    public Word update(Word word);
    public List<Word> getAll();
    public int delete(int id);
    public List<Word> getMatchingWords(String wordStr);



}
