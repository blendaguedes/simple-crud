package com.bureau.simplecrud.dao;

import com.bureau.simplecrud.model.Translator;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslatorDAO extends CrudRepository<Translator, Integer>, JpaSpecificationExecutor<Translator> {

    @Override
    List<Translator> findAll();

}
