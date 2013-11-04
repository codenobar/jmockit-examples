package com.apigee.codecoverage;

import com.apigee.Environment;
import com.apigee.Organization;
import com.apigee.Singleton;
import com.apigee.Utils;
import junit.framework.Assert;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Test;

import java.sql.Timestamp;


public class MessengerTest {

    @Mocked(stubOutClassInitialization = true)
    private Utils utils;
    @Mocked Singleton singleton;

    @Test
    public void printMessage() throws Exception {

        new NonStrictExpectations() {
            {
                Singleton.getInstance();
                returns(singleton);
                singleton.message(anyInt);
                returns("message-" + anyInt.toString());
            }
        };
        Messenger m = new Messenger(singleton);
        m.printMessage(100);
    }

    @Test
    public void printTimestamp() {
        new NonStrictExpectations() {
            {
                Utils.getMessageTimestamp(anyInt);
                returns(new Timestamp(System.currentTimeMillis()));
                Utils.getTypeMap(anyInt);
                returns(new String(""));
            }
        };
        Messenger m = new Messenger(singleton);
        m.printTimestamp(100);
    }

    @Test
    public void printOrgEnv() {
        new NonStrictExpectations() {
            Organization organization;
            Environment environment;
            {
                Singleton.getInstance();
                returns(singleton);
                singleton.getOrganization();
                returns(organization);
                singleton.getEnvironment();
                returns(environment);
                environment.getEnvironmentName();
                returns("my-env");
                organization.getOrganizationName();
                returns("my-org");
            }
        };
        Messenger m = new Messenger(singleton);
        m.printOrg();
        m.printEnv();
    }

    @Test
    public void printOrgEnv2() {

        final Environment environment = new MockUp<Environment>() {
            @Mock
            public String getEnvironmentName() {
                return "my-env2";
            }
        }.getMockInstance();

        final Organization organization = new MockUp<Organization>() {
            @Mock
            public String getOrganizationName() {
                return "my-org2";
            }
        }.getMockInstance();

        new NonStrictExpectations() {
            {
                Singleton.getInstance();
                returns(singleton);
                singleton.getEnvironment();
                returns(environment);
                singleton.getOrganization();
                returns(organization);
            }
        };
        Messenger m = new Messenger(singleton);
        m.printEnv();
        m.printOrg();
    }
} 
