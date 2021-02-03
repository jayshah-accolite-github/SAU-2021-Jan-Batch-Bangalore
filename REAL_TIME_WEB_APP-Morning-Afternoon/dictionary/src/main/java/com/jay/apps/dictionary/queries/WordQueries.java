package com.jay.apps.dictionary.queries;

import com.jay.apps.dictionary.table.constants.WordTableConstants;

public class WordQueries {

    private WordQueries() {

    }
    public static final String INSERT_QUERY = "INSERT INTO " + WordTableConstants.TABLE_NAME + "("
            + WordTableConstants.WORD + " , " + WordTableConstants.MEANING + " , " + WordTableConstants.POS + " , "
            + WordTableConstants.EXAMPLE + " , " + WordTableConstants.CREATION_TM + " , "
            + WordTableConstants.LAST_MODIFIED_TM + ") " + " VALUES (" + " :" + WordTableConstants.WORD + " , :"
            + WordTableConstants.MEANING + " , :" + WordTableConstants.POS + " , :" + WordTableConstants.EXAMPLE
            + " , :" + WordTableConstants.CREATION_TM + " , :" + WordTableConstants.LAST_MODIFIED_TM + " )";

    public static final String DELETE_QUERY = "DELETE FROM " + WordTableConstants.TABLE_NAME + " WHERE "
            + WordTableConstants.ID + " =:" + WordTableConstants.ID;

    public static final String UPDATE_QUERY = " UPDATE " + WordTableConstants.TABLE_NAME
            + " SET " + WordTableConstants.WORD + " =:" + WordTableConstants.WORD + " , "
            + WordTableConstants.MEANING + " =:" + WordTableConstants.MEANING + " , "
            + WordTableConstants.POS + " =:" + WordTableConstants.POS + " , "
            + WordTableConstants.EXAMPLE + " =:" + WordTableConstants.EXAMPLE + " , "
            + WordTableConstants.LAST_MODIFIED_TM + " =:" + WordTableConstants.LAST_MODIFIED_TM
            + " WHERE  " + WordTableConstants.ID + " =:" + WordTableConstants.ID;


    public static final String GET_ALL_QUERY = "SELECT * FROM "
            +WordTableConstants.TABLE_NAME+" ORDER BY "+WordTableConstants.CREATION_TM+" DESC ";

    public static final String MATCHING_QUERY = "SELECT * FROM " + WordTableConstants.TABLE_NAME + " where "
            + WordTableConstants.WORD + " LIKE  '";

}