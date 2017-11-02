package com.patternson.projectideas.entities.facades;

import com.patternson.projectideas.entities.ProjectIdea;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class ProjectIdeaFacade {
    @PersistenceContext(unitName="projectideas")
    private EntityManager em;

    public List<ProjectIdea> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<ProjectIdea> cq = cb.createQuery(ProjectIdea.class);
        cq.select(cq.from(ProjectIdea.class));
        return em.createQuery(cq).getResultList();
    }
}
