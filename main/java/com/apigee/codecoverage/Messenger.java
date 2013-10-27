package com.apigee.codecoverage;

import com.apigee.Singleton;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Messenger {

    private Singleton s;

    public Messenger(Singleton s) {
        this.s = s;
    }

    public void printMessage (int k) {
        Logger.getLogger(Messenger.class.getName()).log(Level.ALL, "msg for " + k + " is: " + s.message(k));
    }
}
