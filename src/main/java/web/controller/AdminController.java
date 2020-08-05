package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.List;

@RestController
@SessionAttributes("list")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public  ModelAndView getAdminPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("adminPage");
        return model;
    }

    @GetMapping("/admin/getListUsers")
    public ResponseEntity<List<User>> getListUsers() {
        List<User> list = userService.findAll();
        if(list.size() > 0) {
            return  new ResponseEntity(list, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/admin/getListRoles")
    public ResponseEntity<List<Role>> getListRoles() {
        List<Role> list = roleService.findAll();
        if(list.size() > 0) {
            return  new ResponseEntity(list, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
