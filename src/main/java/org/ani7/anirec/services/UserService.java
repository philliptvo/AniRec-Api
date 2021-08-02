package org.ani7.anirec.services;

import org.ani7.anirec.models.User;
import org.ani7.anirec.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public Optional<User> getUserByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    public void deleteUserByUserName(String userName) {
        repository.deleteById(userName);
    }
}
