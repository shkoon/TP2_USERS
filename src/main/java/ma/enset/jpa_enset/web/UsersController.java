package ma.enset.jpa_enset.web;

import ma.enset.jpa_enset.entities.User;
import ma.enset.jpa_enset.repositories.UserRepository;
import ma.enset.jpa_enset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{username}")
    User user(@PathVariable String username){
        return userService.findUserByUserName(username);
    }
}
