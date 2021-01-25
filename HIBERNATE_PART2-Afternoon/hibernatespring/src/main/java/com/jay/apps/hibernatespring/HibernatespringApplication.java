package com.jay.apps.hibernatespring;

import com.jay.apps.hibernatespring.models.*;

import com.jay.apps.hibernatespring.repository.QuoteJPARepo;

import com.jay.apps.hibernatespring.repository.QuoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class HibernatespringApplication implements CommandLineRunner {

    @Autowired
    QuoteJPARepo quoteJPARepository;

    @Autowired
    QuoteRepo quoteRepo;

    public static void main(String[] args) {
        SpringApplication.run(HibernatespringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Category category = new Category();
        category.setName("Motivation");

        Category category2 = new Category();
        category2.setName("Friendship");

        Set<Category> categorySet = new HashSet<>();
        categorySet.add(category);
        categorySet.add(category2);


        Author author = new Author();

        author.setName("Uzumaki Naruto");

        Quote quote = new Quote();
        quote.setId(1);
        quote.setAuthor(author);
        quote.setCategorySet(categorySet);
        quote.setQuote("aaaaaaaaaaaaaaaaaaa");

        Author author2 = new Author();

        author.setName("Sasuke Uchiha");

        Quote quote2 = new Quote();
        quote2.setId(2);
        quote2.setAuthor(author2);
        quote2.setCategorySet(categorySet);
        quote2.setQuote("bbbbbbbbbbnnnnnnnZZZZZZZZZZZZb");


//CREATE
//        quoteJPARepository.save(quote);
//        quoteJPARepository.save(quote2);
//DELETE
//        quoteJPARepository.delete(quote2);
//        quoteJPARepository.deleteAll();
//READ
//        Optional<Quote> q1 = quoteJPARepository.findById(1);
//        System.out.println(q1.get().getQuote());
//        List<Quote> quotes=quoteRepo.getQuoteUsingAuthorId(1);
//        System.out.println(quotes.get(0).getQuote());
//UPDATE
//        String updatedOuote="ccccccccccccccccc";
//        int updateId=1;
//        quoteRepo.updateQuoteText(updatedOuote,updateId);
//
//        Optional<Quote> q1 = quoteJPARepository.findById(1);
//        System.out.println(q1.get().getQuote());












    }
}
