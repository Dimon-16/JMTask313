package web.repositories;

import web.model.User;

import java.util.List;

public interface EntityRepository {

    void save(User user);

    User findById(Long id);

    List<User> findAll();

    void delete(User user);

    User findByEmail(String email);

    User update(User user);
}
