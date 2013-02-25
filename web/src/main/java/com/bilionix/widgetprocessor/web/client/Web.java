package com.bilionix.widgetprocessor.web.client;

import com.bilionix.widgetprocessor.web.shared.MainRequestFactory;
import com.bilionix.widgetprocessor.web.shared.WidgetProxy;
import com.bilionix.widgetprocessor.web.shared.WidgetRequestContext;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 *
 */
public class Web implements EntryPoint {

    private static final EventBus eventBus = new SimpleEventBus();

    private static final MainRequestFactory requestFactory = GWT.create(MainRequestFactory.class);
    static {
        requestFactory.initialize(eventBus);
    }

    public static MainRequestFactory getRequestFactory() {
        return requestFactory;
    }

    public void onModuleLoad() {
        WidgetRequestContext request = requestFactory.widget();
        WidgetProxy entity = request.create(WidgetProxy.class);
        request.processWidget(entity);
        request.fire();
    }
}
