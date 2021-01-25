package com.jay.apps.hibernatespring.models;


import javax.persistence.*;

import java.util.Set;

@Entity
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @Column
    String quote;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Author author;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Set<Category> categorySet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }
}
