package com.apigee;

import org.junit.*;
import mockit.*;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;

import com.apigee.codecoverage.MyClass;

@RunWith(JMockit.class)
public class MyClassTest {

    @Mocked Someobject object;

    @Test
    public void testMethod1() throws Exception {
        new CommonNonStrictExpectations() {};
        new NonStrictExpectations() {
            {
                object.getInt(anyInt); returns (-1);
                object.getString(anyInt); returns ("failure");
            }
        };
        System.out.println("position: " + object.getInt(1));
        System.out.println("exec status: " + object.getString(1));
        MyClass m = new MyClass();
        m.method(object, -1);
    }

    private class CommonNonStrictExpectations extends NonStrictExpectations {
        public CommonNonStrictExpectations () throws Exception {
            object.getInt(anyInt); returns (1);
            object.getString(anyInt); returns ("success");
        }
    }
}
