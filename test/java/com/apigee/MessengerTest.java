package com.apigee;

import com.apigee.codecoverage.Messenger;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Test;

public class MessengerTest {

    @Test
    public void printMessage(@Mocked final Singleton singleton) throws Exception {

        new NonStrictExpectations() {
            {
                Singleton.getInstance(); returns (singleton);
                singleton.message(anyInt); returns ("message-" + anyInt.toString());
            }
        };
        Messenger m = new Messenger(singleton);
        m.printMessage(200);
    }


} 
