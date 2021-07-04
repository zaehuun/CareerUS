package com.project.backend.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);

//    @Query()
//    List<User> getCurrentUsers();

    List<User> findTop9ByOrderByPk();
    List<User> findTop3ByOrderByView();

}
