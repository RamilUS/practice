package ru.bellintegrator.practice.user;

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
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public List<User> all()  {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery(User.class);
        cQuery.from(User.class);
        Query query = em.createQuery(cQuery);
        return query.getResultList();
    }


    @Override
    public User loadById(Integer id) {
        return em.find(User.class, id);
    }
    @Override
    public void save(User organization) {
        em.persist(organization);
    }


    @Override
    public void update(User user)  {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<User> cUpdate = builder.createCriteriaUpdate(User.class);
        Root users = cUpdate.from(User.class);
        cUpdate.where(builder.equal(users.get("id"),user.getId()));
        cUpdate.set("office_id",user.getOffice_id());
        cUpdate.set("first_name",user.getFirst_name());
        cUpdate.set("last_name",user.getLast_name());
        cUpdate.set("second_name",user.getSecond_name());
        cUpdate.set("middle_name",user.getMiddle_name());
        cUpdate.set("position",user.getPosition());
        cUpdate.set("phone",user.getPhone());
        cUpdate.set("doc_id",user.getDoc_id());
        cUpdate.set("citizenship_id",user.getCitizenship_id());
        cUpdate.set("is_identified",user.getIs_identified());

        Query query = em.createQuery(cUpdate);
        query.executeUpdate();
    }
}
