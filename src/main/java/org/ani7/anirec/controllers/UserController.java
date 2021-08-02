package org.ani7.anirec.controllers;

import org.ani7.anirec.models.User;
import org.ani7.anirec.payloads.UserSummary;
import org.ani7.anirec.security.CurrentUser;
import org.ani7.anirec.security.UserPrincipal;
import org.ani7.anirec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/me")
    public ResponseEntity<UserSummary> getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary user = new UserSummary(currentUser.getUsername(), currentUser.getFirstName(),
                currentUser.getLastName(), currentUser.getEmail(), currentUser.getGender(),
                currentUser.getDateOfBirth());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("")
    public List<User> getAllUsers(@RequestParam(defaultValue = "1") String pageNum,
                                  @RequestParam(defaultValue = "25") String pageSize) {
        Page<User> page = service.findAllUsers(Integer.parseInt(pageNum) - 1, Integer.parseInt(pageSize));
        return page.getContent();
    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        try {
            User user = service.getUserByUserName(userName).orElseThrow(() -> new NoSuchElementException());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{userName}")
    public ResponseEntity<User> updateUserByUserName(@RequestBody User user, @PathVariable String userName) {
        try {
            User oldUser = service.getUserByUserName(userName).orElseThrow(() -> new NoSuchElementException());
            service.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<User> deleteUserByUserName(@PathVariable String userName) {
        try {
            service.deleteUserByUserName(userName);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
