package com.apigee;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Event
{
    private Random r = new Random ();
    private final Logger logger = Logger.getLogger(Event.class.getName());

	public String getExecutionStatus(int i) {
        if (i < 0)
            return "FAILURE";
        else if (i > 0)
             return "SUCCESS";
        else
            return "";
    }

    public int getRandomPosition() {
        r.setSeed(System.currentTimeMillis());
        return (-3 + r.nextInt(4));
    }

    public String printMessage (String status) throws StatusUpdateException {
        if (status == null || status.isEmpty()) {
            logger.log(Level.INFO, "status cannot be null or empty");
            throw new StatusUpdateException ("StatusUpdateException");
        }
        return  "status is: " + status;
    }

}
