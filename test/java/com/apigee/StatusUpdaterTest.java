package com.apigee;

import com.apigee.codecoverage.StatusUpdater;
import org.junit.*;
import mockit.*;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;



/**
 * StatusUpdater Tester.
 */

@RunWith(JMockit.class)
public class StatusUpdaterTest {

    @Mocked Event event;

    @Ignore @Test
    public void updaterForSuccess() throws Exception {
        new Expectations() {
            {
                event.getRandomPosition(); returns (anyInt);
                event.getExecutionStatus(anyInt); returns ("success");
                event.printMessage(anyString); returns ("status is success");
            }
        };
        StatusUpdater s = new StatusUpdater();
        s.updater(event);
    }

    @Test
    public void updaterForFailure() throws Exception {
        new CommonNonStrictExpectations() {};
        new NonStrictExpectations() {
            {
                //event.getRandomPosition(); returns (anyInt);
                event.getExecutionStatus(anyInt); returns ("failure");
                event.printMessage(anyString); returns ("status is failure");
            }
        };
        //getExpectations ();
        System.out.println("event: " + event.getExecutionStatus(10));
        StatusUpdater s = new StatusUpdater();
        s.updater(event);
    }

    @Ignore @Test
    public void updaterForException() throws Exception {
        new CommonNonStrictExpectations() {};
        StatusUpdater s = new StatusUpdater();
        s.updater(event);
    }

    private class CommonNonStrictExpectations extends NonStrictExpectations {
        public CommonNonStrictExpectations () throws StatusUpdateException {
            event.getRandomPosition(); returns (anyInt);
            event.getExecutionStatus(anyInt); returns (anyString);
            //event.printMessage(anyString); result = new StatusUpdateException("");
            //event.printMessage(anyString); result = new StatusUpdateException("", new Throwable());
        }
    }

    private NonStrictExpectations getExpectations () throws StatusUpdateException {
        return new NonStrictExpectations() {
            {
                event.getRandomPosition(); returns (anyInt);
                event.getExecutionStatus(anyInt); returns ("failure");
                event.printMessage(anyString); returns ("status is failure");
            }
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
    }

} 
