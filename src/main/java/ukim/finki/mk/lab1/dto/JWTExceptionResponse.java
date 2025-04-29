package ukim.finki.mk.lab1.dto;

import java.util.Date;

public record JWTExceptionResponse (
        Date timestamp,
        int status,
        String error,
        String message,
        String path
){
    public JWTExceptionResponse(int status,String error,String message,String path){
        this(new Date(),status,error,message,path);
    }
}
