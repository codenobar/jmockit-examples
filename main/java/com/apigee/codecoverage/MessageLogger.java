package com.apigee.codecoverage;

import com.apigee.Environment;
import com.apigee.Messenger;
import com.apigee.Organization;
import com.apigee.Utils;

public class MessageLogger {

    Messenger messenger = null;

    public MessageLogger(Messenger messenger) {
        this.messenger = messenger;
    }

    public void printMessage(int k) {
        System.out.println("msg for " + k + " is: " + messenger.message(k));
    }

    public void printTimestamp(int id, int code) {
        System.out.println("timestamp for msg id: " + id + " is: " + Utils.getMessageTimestamp(id) + " and msg type is: " + Utils.getTypeMap(code));
    }

    public void printOrg() {
        System.out.println("org name is: " + messenger.getOrganization().getOrganizationInfo());
    }

    public void printEnv() {
        System.out.println("env name is: " + messenger.getEnvironment().getEnvironmentInfo());
    }

    public void SetMessage (String orgName, String envName) {
        // business logic to add/update org info
        messenger.setOrganization(new Organization() {
            @Override
            public String getOrganizationInfo() {
                return null;
            }
        });
        // business logic to add/update env info
        messenger.setEnvironment(new Environment() {
            @Override
            public String getEnvironmentInfo() {
                return null;
            }
        });
        // business logic to add/update message for the given org & env
        messenger.messageComposer(129);
    }
}
