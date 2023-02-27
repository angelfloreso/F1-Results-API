package com.apex.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
public class ItemNotFoundException extends Exception{

    public ItemNotFoundException(Long id){
        super(String.format("No item were found for id : %s", id));

    }
}
