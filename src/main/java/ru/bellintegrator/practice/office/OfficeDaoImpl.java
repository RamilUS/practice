package ru.bellintegrator.practice.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class OfficeDaoImpl implements OfficeDao {
    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public List<Office> all()  {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery(Office.class);
        cQuery.from(Office.class);
        Query query = em.createQuery(cQuery);
        return query.getResultList();
    }


    @Override
    public Office loadById(Integer id) {
        return em.find(Office.class, id);
    }

    @Override
    public List<Office> loadByOrgId(Integer org_id)  {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Office> cQuery = builder.createQuery(Office.class);
        Root<Office> root = cQuery.from(Office.class);
        cQuery.select(root);
        cQuery.where(builder.equal(root.get("org_id"),org_id));
        Query query = em.createQuery(cQuery);
        return query.getResultList(); //em.find(Office.class, org_id);
    }


    @Override
    public void save(Office organization) {
        em.persist(organization);
    }


    @Override
    public void update(Office office)  {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<Office> cUpdate = builder.createCriteriaUpdate(Office.class);
        Root Offices = cUpdate.from(Office.class);
        cUpdate.where(builder.equal(Offices.get("id"),office.getId()));
        cUpdate.set("active",office.getActive());
        cUpdate.set("phone",office.getPhone());
        cUpdate.set("address",office.getAddress());
        cUpdate.set("name",office.getName());
        cUpdate.set("org_id",office.getOrg_id());


        Query query = em.createQuery(cUpdate);
        query.executeUpdate();
    }
}
