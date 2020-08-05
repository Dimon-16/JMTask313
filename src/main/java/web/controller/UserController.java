package web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;

@RestController
@SessionAttributes("user")
public class UserController {

    @GetMapping("/getUser")
    public ResponseEntity<User> getUserPage(@ModelAttribute User user) {

        if(user != null) {
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user")
    public ModelAndView getUserPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("userPage");
        return model;
    }

}
