package org.ani7.anirec.repositories;

import org.ani7.anirec.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    public Optional<User> findByUserName(String userName);

    public Optional<User> findByUserNameOrEmail(String userName, String email);

    public boolean existsByUserName(String userName);

    public boolean existsByEmail(String email);
}
