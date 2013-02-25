package com.bilionix.widgetprocessor.ejb;

import com.bilionix.widgetprocessor.domain.Widget;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 *
 */
public class WidgetDAO {

    @PersistenceContext
    protected EntityManager em;

    private CriteriaBuilder builder;

    protected CriteriaBuilder getBuilder() {
        if (builder == null) {
            builder = em.getCriteriaBuilder();
        }
        return builder;
    }

    protected void beforePersist(Widget entity) {

    }

    protected void afterPersist(Widget entity) {

    }

    protected void beforeUpdate(Widget entity) {

    }

    protected void beforeCreate(Widget entity) {

    }

    public Long persist(Widget entity) {
        beforePersist(entity);
        if (entity.getId() != null) {
            beforeUpdate(entity);
            entity = em.merge(entity);
        }
        else {
            beforeCreate(entity);
            em.persist(entity);
        }
        afterPersist(entity);
        return entity.getId();
    }

    public void remove(Widget entity) {
        entity = get(entity.getId());
        if (entity != null) {
            em.remove(entity);
        }
    }

    public void remove(Long id) {
        Widget entity = get(id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Widget get(Long id) {
        Widget result = null;
        if (id != null && id > 0) {
            result = em.find(Widget.class, id);
        }
        return result;
    }

    public List<Widget> listAll(int start, int count) {
        CriteriaQuery<Widget> criteria = getBuilder().createQuery(Widget.class);
        criteria.orderBy(getBuilder().asc(criteria.from(Widget.class).get("id")));
        TypedQuery<Widget> query = em.createQuery(criteria);
        query.setFirstResult(start);
        if (count > 0) {
            query.setMaxResults(count);
        }
        return query.getResultList();
    }

    public List<Widget> listAll() {
        return listAll(0, 0);
    }
}
