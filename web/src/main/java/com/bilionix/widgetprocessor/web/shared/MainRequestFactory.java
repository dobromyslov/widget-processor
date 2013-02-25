package com.bilionix.widgetprocessor.web.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

/**
 *
 */
public interface MainRequestFactory extends RequestFactory {
    WidgetRequestContext widget();
}
