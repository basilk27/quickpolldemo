package com.mbsystems.quickpolldemo.repository;

import com.mbsystems.quickpolldemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername( String username );
    User findUserByUsername( String username );
}