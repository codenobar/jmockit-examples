package com.apigee.codecoverage;

import com.apigee.Someobject;

public class MyClass {

    public void method (Someobject someobject, int i) {
        String status = someobject.getString(i);
        if (status.equalsIgnoreCase("success")) {
            print(someobject, "success");
        }  else if (status.equalsIgnoreCase("failure")) {
            print(someobject, "failure");
        } else
            print(someobject, "");
    }

    private String print(Someobject someobject, String status) {
        return someobject.printMessage (status);
    }
}
