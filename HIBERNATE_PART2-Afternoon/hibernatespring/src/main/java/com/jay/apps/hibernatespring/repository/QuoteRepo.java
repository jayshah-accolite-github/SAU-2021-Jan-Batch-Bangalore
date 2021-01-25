package com.jay.apps.hibernatespring.repository;

import com.jay.apps.hibernatespring.models.Quote;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class QuoteRepo {
    @PersistenceContext
    EntityManager entityManager;





    public void updateQuoteText(String updatedText,int id){

    Query query =  entityManager.createNativeQuery("update quote set quote = :text where quote.id= :id");
    query.setParameter("text",updatedText);
    query.setParameter("id",id);
    query.executeUpdate();

    }

    public List<Quote> getQuoteUsingAuthorId(int id) {
        Query query =
                entityManager.createQuery("select q from Quote q where q.author.id = :id");
        query.setParameter("id", id);

//        entityManager.createNativeQuery("select * from movie m where m.release_year > 0");

        return query.getResultList();

    }

}
