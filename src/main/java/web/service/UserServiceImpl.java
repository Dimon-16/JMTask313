package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;
import web.repositories.EntityRepository;
import web.repositories.JpaEntityManagerRepository;
import web.repositories.RoleRepositoryImpl;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private EntityRepository userRepository;
    private RoleRepositoryImpl roleRepository;

    @Autowired
    public UserServiceImpl(JpaEntityManagerRepository userRepository, RoleRepositoryImpl roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    @Transactional
    public void save(User user) {
        Role roleDB;

        User hasAUser = userRepository.findByEmail(user.getEmail());
        if(hasAUser == null) {
            for (Role role: user.getRoles()) {
               roleDB = roleRepository.findByName(role.getName());
               if(roleDB != null) {
                   role.setId(roleDB.getId());
               }
            }
            userRepository.save(user);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> list = (List<User>) userRepository.findAll();
        return list;
    }

    @Override
    @Transactional
    public void deleteByEmail(String email) {
         User user = userRepository.findByEmail(email);
         userRepository.delete(user);
    }

    @Override
    public User findByEmail(String email) {
            return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public User update(User user) {
        Role roleDB;
        User userForUpdate = userRepository.findById(user.getId());
        user.setPassword(userForUpdate.getPassword());
        for (Role role: user.getRoles()) {
            roleDB = roleRepository.findByName(role.getName());
            if(roleDB != null) {
                role.setId(roleDB.getId());
            }
        }
        return userRepository.update(user);
    }


}
