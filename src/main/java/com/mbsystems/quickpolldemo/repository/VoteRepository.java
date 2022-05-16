package com.mbsystems.quickpolldemo.repository;

import com.mbsystems.quickpolldemo.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}