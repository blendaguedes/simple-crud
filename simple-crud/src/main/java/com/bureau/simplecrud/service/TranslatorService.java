package com.bureau.simplecrud.service;

import com.bureau.simplecrud.dao.TranslatorDAO;
import com.bureau.simplecrud.dao.TranslatorPaginatorDAO;
import com.bureau.simplecrud.exception.TranslatorNotFoundException;
import com.bureau.simplecrud.model.Translator;
import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class TranslatorService {

    private final TranslatorDAO translatorDAO;

    private final TranslatorPaginatorDAO translatorPaginatorDAO;

    public TranslatorService(TranslatorDAO translatorDAO, TranslatorPaginatorDAO translatorPaginatorDAO) {
        this.translatorDAO = translatorDAO;
        this.translatorPaginatorDAO = translatorPaginatorDAO;
    }

    public Translator addTranslator(Translator translator) {
        return translatorDAO.save(translator);
    }

    public Long getListSize() {
        return translatorDAO.count();
    }

    public List<Translator> getTranslatorList(Specification<Translator> specification) {
        return translatorDAO.findAll(specification);
    }

    public Translator getTranslator(int costumerId) {
        Optional<Translator> optionalTranslator = translatorDAO.findById(costumerId);
        if(!optionalTranslator.isPresent()){
            throw new TranslatorNotFoundException("Translator Record Not Found");
        }
        return optionalTranslator.get();
    }

    public Translator updateTranslator(int costumerId, Translator translator) {
        translator.setId(costumerId);
        return translatorDAO.save(translator);
    }

    public void deleteTranslator(int costumerId) {
        translatorDAO.deleteById(costumerId);
    }

    public List<Translator> getTranslators(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Translator> pagedResult = translatorPaginatorDAO.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Translator>();
        }
    }
}
