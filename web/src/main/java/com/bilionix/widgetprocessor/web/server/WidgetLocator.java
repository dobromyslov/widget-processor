package com.bilionix.widgetprocessor.web.server;

import com.bilionix.widgetprocessor.domain.Widget;
import com.bilionix.widgetprocessor.ejb.WidgetProcessor;
import com.google.web.bindery.requestfactory.shared.Locator;

/**
 *
 */
public class WidgetLocator extends Locator<Widget, Long> {

    @Override
    public Widget create(Class<? extends Widget> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Widget find(Class<? extends Widget> clazz, Long id) {
        return ((WidgetProcessor) BeanLocator.lookupBean(clazz)).get(id);
    }

    @Override
    public Class<Widget> getDomainType() {
        return Widget.class;
    }

    @Override
    public Long getId(Widget domainObject) {
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(Widget domainObject) {
        return domainObject.getVersion();
    }
}
