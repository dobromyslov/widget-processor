package com.bilionix.widgetprocessor.web.server;

import com.bilionix.widgetprocessor.domain.Widget;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

import javax.naming.InitialContext;

/**
 *
 */
public class BeanLocator implements ServiceLocator {
    @Override
    public Object getInstance(Class<?> clazz) {
        return lookupBean(clazz);
    }

    public static Object lookupBean(Class<?> clazz) {
        if (clazz.equals(Widget.class)) {
            try {
                return InitialContext.doLookup("com.bilionix.widgetprocessor.ejb.WidgetProcessor");
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        else {
            return null;
        }
    }
}