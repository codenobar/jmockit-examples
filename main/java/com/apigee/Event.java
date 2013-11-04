package com.apigee;

import java.util.Random;

public final class Event
{
    private Random r = new Random ();

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

    public void printMessage (String status) throws StatusUpdateException {
        if (status == null || status.isEmpty()) {
            System.out.println("status cannot be null or empty");
            throw new StatusUpdateException ("StatusUpdateException");
        } else
            System.out.println("status is: " + status);
    }
}
