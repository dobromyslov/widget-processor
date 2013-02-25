package com.bilionix.widgetprocessor.web.shared;

import com.bilionix.widgetprocessor.ejb.WidgetProcessor;
import com.bilionix.widgetprocessor.web.server.BeanLocator;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

/**
 *
 */
@Service(value = WidgetProcessor.class, locator = BeanLocator.class)
public interface WidgetRequestContext extends RequestContext {
    Request<Void> processWidget(WidgetProxy widget);
}
