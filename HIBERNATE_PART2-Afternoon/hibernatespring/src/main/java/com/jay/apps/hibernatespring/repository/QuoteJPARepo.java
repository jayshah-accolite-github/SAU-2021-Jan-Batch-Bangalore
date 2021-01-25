package com.jay.apps.hibernatespring.repository;

import com.jay.apps.hibernatespring.models.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface QuoteJPARepo extends CrudRepository<Quote,Integer> {

    @Override
    <S extends Quote> S save(S s);

    @Override
    <S extends Quote> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Quote> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<Quote> findAll();

    @Override
    Iterable<Quote> findAllById(Iterable<Integer> iterable);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Quote quote);

    @Override
    void deleteAll(Iterable<? extends Quote> iterable);

    @Override
    void deleteAll();


}
