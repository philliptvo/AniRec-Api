package org.ani7.anirec.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import org.ani7.anirec.models.User;
import org.ani7.anirec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/user")
    public List<User> getAllUsers(@RequestParam(defaultValue = "1") String pageNum,
                                  @RequestParam(defaultValue = "25") String pageSize) {
        Page<User> page = service.findAllUsers(
            Integer.parseInt(pageNum) - 1,
            Integer.parseInt(pageSize));
        return page.getContent();
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        try {
            User user = service.getUserByUserName(userName);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        service.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("user/{userName}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userName) {
        try {
            User originalUser = service.getUserByUserName(userName);
            user.setUserName(userName);
            service.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{userName}")
    public ResponseEntity<User> deleteUser(@PathVariable String userName) {
        try {
            service.deleteUserByUserName(userName);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
