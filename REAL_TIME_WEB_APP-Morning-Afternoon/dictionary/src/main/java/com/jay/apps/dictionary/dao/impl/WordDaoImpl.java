package com.jay.apps.dictionary.dao.impl;

import com.jay.apps.dictionary.dao.IWordDao;
import com.jay.apps.dictionary.models.Word;
import com.jay.apps.dictionary.queries.WordQueries;
import com.jay.apps.dictionary.table.constants.WordTableConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jay.apps.dictionary.queries.WordQueries.*;

@Repository
public class WordDaoImpl implements IWordDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Word save(Word word) {
        final KeyHolder holder = new GeneratedKeyHolder();
        String sql =INSERT_QUERY;

        MapSqlParameterSource srcMap = new MapSqlParameterSource();
        srcMap.addValue(WordTableConstants.WORD, word.getWord());
        srcMap.addValue(WordTableConstants.MEANING, word.getMeaning());
        srcMap.addValue(WordTableConstants.POS, word.getPartOfSpeech());
        srcMap.addValue(WordTableConstants.EXAMPLE, word.getExample());
        srcMap.addValue(WordTableConstants.CREATION_TM, word.getCreationTm());
        srcMap.addValue(WordTableConstants.LAST_MODIFIED_TM, word.getLastModifiedTm());

        namedParameterJdbcTemplate.update(sql, srcMap,
                holder, new String[]{"ID"});
        word.setId(holder.getKey().intValue());
        return word;
    }

    @Override
    public Word update(Word word) {
        String sql = UPDATE_QUERY;

        MapSqlParameterSource srcMap = new MapSqlParameterSource();
        srcMap.addValue(WordTableConstants.WORD, word.getWord());
        srcMap.addValue(WordTableConstants.MEANING, word.getMeaning());
        srcMap.addValue(WordTableConstants.POS, word.getPartOfSpeech());
        srcMap.addValue(WordTableConstants.EXAMPLE, word.getExample());
        srcMap.addValue(WordTableConstants.LAST_MODIFIED_TM, word.getLastModifiedTm());
        srcMap.addValue(WordTableConstants.ID,word.getId());

        try {
            namedParameterJdbcTemplate.update(sql, srcMap);
        } catch (Exception e) {
            Word w = new Word();
            w.setWord(e.getLocalizedMessage());
            return w;
        }
        return word;
    }

    @Override
    public List<Word> getAll() {

        String sql = GET_ALL_QUERY;
        return namedParameterJdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Word word = new Word();
            word.setId(resultSet.getInt(WordTableConstants.ID));
            word.setCreationTm(resultSet.getDate(WordTableConstants.CREATION_TM));
            word.setExample(resultSet.getString(WordTableConstants.EXAMPLE));
            word.setLastModifiedTm(resultSet.getDate(WordTableConstants.LAST_MODIFIED_TM));
            word.setMeaning(resultSet.getString(WordTableConstants.MEANING));
            word.setPartOfSpeech(resultSet.getString(WordTableConstants.POS));
            word.setWord(resultSet.getString(WordTableConstants.WORD));
            return word;
        });

    }

    @Override
    public int delete(int id) {
        MapSqlParameterSource srcMap = new MapSqlParameterSource();
        srcMap.addValue(WordTableConstants.ID, id);
        return namedParameterJdbcTemplate.update(WordQueries.DELETE_QUERY, srcMap);
    }

    @Override
    public List<Word> getMatchingWords(String wordStr) {

//        String sql = "select * from words WHERE WORD LIKE '" + wordStr + "%'";
        String sql = MATCHING_QUERY + wordStr + "%'";

        MapSqlParameterSource srcMap = new MapSqlParameterSource();
        srcMap.addValue(WordTableConstants.WORD, wordStr);
        return namedParameterJdbcTemplate.query(sql, srcMap, (resultSet, rowNum) -> {
            Word word = new Word();
            word.setId(resultSet.getInt(WordTableConstants.ID));
            word.setCreationTm(resultSet.getDate(WordTableConstants.CREATION_TM));
            word.setExample(resultSet.getString(WordTableConstants.EXAMPLE));
            word.setLastModifiedTm(resultSet.getDate(WordTableConstants.LAST_MODIFIED_TM));
            word.setMeaning(resultSet.getString(WordTableConstants.MEANING));
            word.setPartOfSpeech(resultSet.getString(WordTableConstants.POS));
            word.setWord(resultSet.getString(WordTableConstants.WORD));

            return word;
        });


    }

}