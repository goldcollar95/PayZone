package com.example.ecommerce.exception;

public class CrudInputValidator {

    public void ValidatorName(String Input) throws IllegalAccessException {
        if(!Input.matches("^[0-9]*$")){
            throw new IllegalAccessException("[ERROR]");
        }
    }
}
