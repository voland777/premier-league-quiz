package com.footballquiz.controller;


public class ContinueController {

    public boolean askIfContinue(String isContinue) {
        if (isContinue.equals("n")) {
            return false;
        } else return true;
    }
}
