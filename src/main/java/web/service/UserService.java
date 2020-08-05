package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);

    List<User> findAll();

    void deleteByEmail(String email);

    User findByEmail(String name);

    User update(User user);
}
