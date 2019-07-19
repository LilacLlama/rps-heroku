/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.rpsboot.biz.exceptions;

/**
 *
 * @author austynhill
 */
public class InvalidChoiceException extends Exception {

    public InvalidChoiceException() {
    }

    public InvalidChoiceException(String message) {
        super(message);
    }

    public InvalidChoiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidChoiceException(Throwable cause) {
        super(cause);
    }

    public InvalidChoiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
