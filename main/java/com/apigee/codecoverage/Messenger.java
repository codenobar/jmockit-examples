package com.apigee.codecoverage;

import com.apigee.Singleton;
import com.apigee.Utils;

public class Messenger {

    Singleton s = null;

    public Messenger (Singleton s) {
        this.s = s;
    }

    public void printMessage (int k) {
        System.out.println("msg for " + k + " is: " + s.message(k));
    }

    public void printTimestamp (int id) {
        System.out.println("timestamp for msg id: " + id + " is: " + Utils.getMessageTimestamp(id));
    }

    public void printOrg () {
        System.out.println("org name is: " + s.getOrganization().getOrganizationName());
    }

    public void printEnv () {
        System.out.println("env name is: " + s.getEnvironment().getEnvironmentName());
    }
}
