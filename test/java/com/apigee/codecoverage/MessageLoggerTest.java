package com.apigee.codecoverage;

import com.apigee.Environment;
import com.apigee.Organization;
import com.apigee.Messenger;
import com.apigee.Utils;
import mockit.*;
import org.junit.Test;

import java.sql.Timestamp;


public class MessageLoggerTest {

    @Mocked
    private Utils utils;
    @Mocked
    private Messenger messenger;
    @Mocked
    private Environment environment;
    @Mocked
    private Organization organization;

    @Test
    public void printMessage() throws Exception {
        commonNonStrictExpectations();
        new NonStrictExpectations() {
            {
                messenger.message(anyInt);
                returns("message-" + anyInt.toString());
            }
        };
        new MessageLogger(messenger).printMessage(100);
        new Verifications() {
            {
                messenger.message(anyInt);
                maxTimes = 1;
            }
        };
    }

    @Test
    public void printTimestamp() {
        new NonStrictExpectations() {
            {
                Utils.getMessageTimestamp(anyInt);
                returns(new Timestamp(System.currentTimeMillis()));
                Utils.getTypeMap(anyInt);
                returns(new String("String-type"));
            }
        };
        new MessageLogger(messenger).printTimestamp(200, 1);
    }

    @Test
    public void printOrgEnv() {
        commonNonStrictExpectations();
        new NonStrictExpectations() {
            {
                messenger.getOrganization();
                returns(organization);
                messenger.getEnvironment();
                returns(environment);
                environment.getEnvironmentInfo();
                returns("my-env");
                organization.getOrganizationInfo();
                returns("my-org");
            }
        };
        MessageLogger m = new MessageLogger(messenger);
        m.printOrg();
        m.printEnv();
        new Verifications() {
            {
                messenger.message(anyInt);
                times = 0;
                messenger.getOrganization();
                minTimes = 1;
                messenger.getEnvironment();
                minTimes = 1;
            }
        };
    }

    @Test
    public void printOrgEnv2() {

        environment = new MockUp<Environment>() {
            @Mock
            public String getEnvironmentInfo() {
                return "my-env2";
            }
        }.getMockInstance();

        organization = new MockUp<Organization>() {
            @Mock
            public String getOrganizationInfo() {
                return "my-org2";
            }
        }.getMockInstance();
        commonNonStrictExpectations();
        new NonStrictExpectations() {
            {
                messenger.getEnvironment();
                returns(environment);
                messenger.getOrganization();
                returns(organization);
            }
        };
        MessageLogger m = new MessageLogger(messenger);
        m.printEnv();
        m.printOrg();
    }

    private NonStrictExpectations commonNonStrictExpectations() {
        return new NonStrictExpectations() {
            {
                Messenger.getInstance();
                returns(messenger);
            }
        };
    }
} 
