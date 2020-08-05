package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.model.User;
import web.service.UserService;

@RestController
public class UpdateController {

    private UserService userService;

    @Autowired
    public UpdateController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/admin/edit")
    public ResponseEntity<User> editUser(@RequestBody User user) {
            if( userService.update(user) != null) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

    }
}
