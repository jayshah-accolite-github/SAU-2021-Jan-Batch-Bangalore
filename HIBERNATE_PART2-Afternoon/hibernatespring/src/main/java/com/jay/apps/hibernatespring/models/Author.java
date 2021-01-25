package com.jay.apps.hibernatespring.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;

//    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    Set<Quote> quotes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<Quote> getQuotes() {
//        return quotes;
//    }
//
//    public void setQuotes(Set<Quote> quotes) {
//        this.quotes = quotes;
//    }
}
