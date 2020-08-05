package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DeleteController {

    private UserService userService;

    @Autowired
    public DeleteController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/admin/delete")
    public ResponseEntity deleteUser(String email) {
        userService.deleteByEmail(email);
        return new ResponseEntity(HttpStatus.OK);
    }
}
