package com.patternson.projectideas.entities.facades;

import com.patternson.projectideas.entities.ProjectIdea;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LocatorEx;

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


    public ProjectIdea find(int id) {
        return em.find(ProjectIdea.class, id);
    }

    public void delete(int id) {
        em.remove(id);
    }


    public List<ProjectIdea> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProjectIdea> cq = cb.createQuery(ProjectIdea.class);
        cq.select(cq.from(ProjectIdea.class));
        return em.createQuery(cq).getResultList();
    }

//    public T find(Object id) {
//        return getEntityManager().find(entityClass, id);
//    }
//
//    public List<T> findAll() {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        return getEntityManager().createQuery(cq).getResultList();
//    }

    public void create(ProjectIdea entity) {
        em.persist(entity);
    }

    public void edit(ProjectIdea entity) {
        em .merge(entity);
    }



//    CriteriaBuilder cb = em.getCriteriaBuilder();
//    CriteriaQuery<Object> cq = cb.createQuery();
//    Root<Snapshot> r = cq.from(Snapshot.class);
//cq.where(cb.equal(r.get("systemID"), systemID));
//cd.orderBy(cb.desc(r.get("id")));
//em.createQuery(cq).geFirsttResult();
}