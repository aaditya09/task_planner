package com.app.planner.exception;

/**
 * Created by Aaditya.t on 24/7/19.
 */


public class InvalidStateException extends RuntimeException{

    public InvalidStateException(String msg){
        super(msg);
    }
}
