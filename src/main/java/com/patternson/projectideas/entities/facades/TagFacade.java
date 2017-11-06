package com.patternson.projectideas.entities.facades;

import com.patternson.projectideas.entities.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TagFacade {
    @PersistenceContext(unitName = "projectideas")
    private EntityManager em;

    public List<Tag> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Tag> cq = cb.createQuery(Tag.class);
        cq.select(cq.from(Tag.class));
        return em.createQuery(cq).getResultList();
    }
}