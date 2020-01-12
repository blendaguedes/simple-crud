package com.bureau.simplecrud.exception;

public class TranslatorNotFoundException extends RuntimeException {
    public TranslatorNotFoundException(String message){
        super(message);
    }
}
