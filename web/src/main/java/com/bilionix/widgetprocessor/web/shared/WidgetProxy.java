package com.bilionix.widgetprocessor.web.shared;

import com.bilionix.widgetprocessor.domain.Widget;
import com.bilionix.widgetprocessor.web.server.WidgetLocator;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

/**
 *
 */
@ProxyFor(value = Widget.class, locator = WidgetLocator.class)
public interface WidgetProxy extends EntityProxy {
    Long getId();

    @Override
    EntityProxyId<WidgetProxy> stableId();
}
