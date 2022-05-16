package com.mbsystems.quickpolldemo.repository;

import com.mbsystems.quickpolldemo.entities.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
}