package com.example.admnapp.util;

public class ErrorHandler extends RuntimeException {
    public ErrorHandler(String message){
        super(message);
    }

    public ErrorHandler(){};
}