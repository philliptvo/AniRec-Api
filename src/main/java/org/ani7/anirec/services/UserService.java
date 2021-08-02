package org.ani7.anirec.services;

import org.ani7.anirec.models.User;
import org.ani7.anirec.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public Page<User> findAllUsers(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.findAll(pageable);
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
