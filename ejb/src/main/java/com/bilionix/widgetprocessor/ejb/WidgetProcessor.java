package com.bilionix.widgetprocessor.ejb;

import com.bilionix.widgetprocessor.domain.Widget;

import javax.ejb.Stateless;

/**
 *
 */
@Stateless
public class WidgetProcessor extends WidgetDAO {

    public void processWidget(Widget w) {
        // Inspect the Widget. If certain properties contain certain
        // values, place it on a queue. Else "process" the Widget
        // and persist it to a DB.
        /*
        if(w.containsSpecialValues())
            QueueManager.sendToQueue(w);
        else {
            // Process widget...

            persist(w);
        }
        */
    }
}
