package com.apigee;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Rupesh Kumar Gopal
 * Date: 04/11/13
 * To change this template use File | Settings | File Templates.
 */
public class Utils {

    public static Timestamp getMessageTimestamp(int id) {
        Timestamp t = null;
        // code to get the timestamp of a given message id
        return t;
    }

    public static Object getTypeMap(int code)
    {
        if (code == 1) {
            return new Boolean("true");
        } else if (code == 2) {
            return new Integer(1);
        } else if (code == 3) {
            return new Double (1.0d);
        } else {
            return new String ("");
        }
    }
}
