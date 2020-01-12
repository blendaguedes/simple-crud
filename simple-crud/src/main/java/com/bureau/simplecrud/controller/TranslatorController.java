package com.bureau.simplecrud.controller;

import com.bureau.simplecrud.model.Paginator;
import com.bureau.simplecrud.model.Translator;
import com.bureau.simplecrud.service.TranslatorService;
import com.sipios.springsearch.anotation.SearchSpec;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/translator")
public class TranslatorController {

    private final TranslatorService translatorService;

    public TranslatorController(TranslatorService translatorService) {
        this.translatorService = translatorService;
    }

    @PostMapping
    public Translator addTranslator(@RequestBody Translator translator){
        return translatorService.addTranslator(translator);
    }

    @GetMapping(value = "{translatorId}")
    public Translator getTranslator(@PathVariable("translatorId") int translatorId){
        return translatorService.getTranslator(translatorId);
    }

    @PatchMapping(value = "{translatorId}")
    public Translator updateTranslator(@PathVariable("translatorId") int translatorId, @RequestBody Translator translator){
       return translatorService.updateTranslator(translatorId, translator);
    }

    @DeleteMapping(value = "{translatorId}")
    public void deleteTranslator(@PathVariable("translatorId") int translatorId){
        translatorService.deleteTranslator(translatorId);
    }

    @GetMapping(value = "searchBy")
    public List<Translator> searchTranslator(@SearchSpec Specification<Translator> specs){
        return translatorService.getTranslatorList(Specification.where(specs));
    }

    @GetMapping
    public Paginator<Translator> getTranslators(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "15") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        Paginator paginator = new Paginator<Translator>();
        paginator.setCurrentPage(pageNo);
        paginator.setPageSize(pageSize);
        List<Translator> list = translatorService.getTranslators(pageNo, pageSize, sortBy);
        Long size = translatorService.getListSize();
        paginator.setSizeList(size.intValue());

        if(pageNo >= size.intValue()/pageSize){
            paginator.setNextPage(null);
        }else{
            paginator.setNextPage(pageNo + 1);
        }

        if(pageNo - 1 < 0){
            paginator.setPreviousPage(null);
        } else {
            paginator.setPreviousPage(pageNo - 1);
        }

        paginator.setList(new ArrayList(list));
        return paginator;
    }

}
