package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {

}