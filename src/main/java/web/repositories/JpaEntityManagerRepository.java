package web.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaEntityManagerRepository implements  EntityRepository{

    private EntityManager entityManager;

   @Autowired
    public JpaEntityManagerRepository(EntityManager entityManager) {
       this.entityManager = entityManager;
   }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Long id) {
       String query = "Select us from User us where us.id = :id";
       User user = (User) entityManager.createQuery(query)
               .setParameter("id", id)
               .getSingleResult();
        return user;
    }

    @Override
    public List<User> findAll() {
       String query = "select user From User user";
       List<User> list = entityManager.createQuery(query)
               .getResultList();
        return list;
    }

    @Override
    public void delete(User user) {
         entityManager.remove(user);
    }

    @Override
    public User findByEmail(String email) {
       String query = "select us from User us where us.email=:userEmail";
       User user = null;
       try {
           user = (User) entityManager.createQuery(query)
                   .setParameter("userEmail", email)
                   .getSingleResult();
       }
       catch(Exception exc) {
           return user;
       }
        return user;
    }

    @Override
    public User update(User user) {
       return entityManager.merge(user);
    }
}
