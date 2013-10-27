package com.apigee.codecoverage;

import com.apigee.Event;
import com.apigee.StatusUpdateException;

import java.util.logging.Logger;


public class StatusUpdater {

    public void updater(Event context) throws Exception {

                String status = context.getExecutionStatus(context.getRandomPosition());
                if (status.equalsIgnoreCase("success")) {
                    print(context, "success");
                }  else if (status.equalsIgnoreCase("failure")) {
                    print(context, "failure");
                } else
                    print(context, "");

    }

    private String print(Event context, String status) {
        String s = null;
        try {
            s = context.printMessage (status);
        } catch (StatusUpdateException e) {
            Logger.getLogger("status update exception" + e);
        }
        return s;
    }

}
