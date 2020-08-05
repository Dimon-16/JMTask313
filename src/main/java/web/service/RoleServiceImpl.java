package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

     private RoleRepository roleRepository;

     @Autowired
     public RoleServiceImpl(RoleRepository roleRepository) {
         this.roleRepository = roleRepository;
     }

    @Override
    @Transactional
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
