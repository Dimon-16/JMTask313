package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.model.User;
import web.service.UserService;

@RestController
public class AddController {

    private UserService userService;

    @Autowired
    public AddController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/admin/add")
    public ResponseEntity addNewUser(@RequestBody User user){
              userService.save(user);
              return new ResponseEntity(HttpStatus.OK);
    }
}
