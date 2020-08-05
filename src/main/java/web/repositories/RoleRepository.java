package web.repositories;

import web.model.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> findAll();

    Role findByName(String name);
}
