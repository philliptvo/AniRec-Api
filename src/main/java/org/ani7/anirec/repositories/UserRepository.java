package org.ani7.anirec.repositories;

import org.ani7.anirec.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
