package web.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements  RoleRepository{

    private EntityManager entityManager;

    @Autowired
    public RoleRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Role> findAll() {
        String query = "select role From Role role";
        List<Role> list = entityManager.createQuery(query)
                .getResultList();
        return list;
    }

    @Override
    public Role findByName(String name) {
        String query = "select role from Role role where role.name = :name";
        Role role;
        try {
            role = (Role) entityManager.createQuery(query)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception exc) {
            return null;
        }
        return role;
    }
}
