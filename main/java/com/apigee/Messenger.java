package com.apigee;

import java.util.HashMap;
import java.util.Map;

public class Messenger {

    private static Messenger instance = new Messenger();
    private Map <Integer, String> map;
    private Organization organization;
    private Environment environment;

    public static Messenger getInstance() {
        if (instance == null)
            instance = new Messenger();
        return instance;
    }

    public String message (int msgId) {
        return map.get(msgId);
    }

    public void messageComposer (int count) {
        map = new HashMap<Integer, String>();
        for (int i=0; i<count; i++) {
            map.put(i,"message-" + String.valueOf(i));
        }
    }

    public void setOrganization (Organization organization) {
        this.organization = organization;
    }

    public void setEnvironment (Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment () {
        return environment;
    }

    public Organization getOrganization () {
        return organization;
    }
}
