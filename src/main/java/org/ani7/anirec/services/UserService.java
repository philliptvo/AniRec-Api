package org.ani7.anirec.services;

import javax.transaction.Transactional;
import org.ani7.anirec.models.User;
import org.ani7.anirec.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getUserByUserName(String userName) {
        return repository.getById(userName);
    }

    public Page<User> findAllUsers(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.findAll(pageable);
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public void deleteUserByUserName(String userName) {
        repository.deleteById(userName);
    }
}
