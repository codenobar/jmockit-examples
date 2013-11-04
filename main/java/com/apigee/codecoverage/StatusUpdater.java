package com.apigee.codecoverage;

import com.apigee.Event;
import com.apigee.StatusUpdateException;


public class StatusUpdater {

    public void updater(Event context) {

                String status = context.getExecutionStatus(context.getRandomPosition());
                if (status.equalsIgnoreCase("success")) {
                    print(context, "success");
                }  else if (status.equalsIgnoreCase("failure")) {
                    print(context, "failure");
                } else
                    print(context, "");

    }

    private void print(Event context, String status) {
        try {
            context.printMessage (status);
        } catch (StatusUpdateException e) {
            // handle exception
            System.out.println("handled status update exception");
        }
    }

}
