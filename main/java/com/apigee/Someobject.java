package com.apigee;

public class Someobject {

    public String getString(int i) {
        if (i < 0)
            return "failure";
        else if (i > 0)
            return "success";
        else
            return "";
    }

    public int getInt(int k) {
        return k;
    }

    public String printMessage (String status) {
        return  "status is: " + status;
    }
}
