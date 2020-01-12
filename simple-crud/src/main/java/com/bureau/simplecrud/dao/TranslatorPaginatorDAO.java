package com.bureau.simplecrud.dao;

import com.bureau.simplecrud.model.Translator;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TranslatorPaginatorDAO extends PagingAndSortingRepository<Translator, Long> {
}
