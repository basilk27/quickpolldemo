package com.mbsystems.quickpolldemo.service;

import com.mbsystems.quickpolldemo.entities.Poll;

import java.util.List;

public interface PollService {

    List<Poll> getAllPolls();
    Poll createPoll( Poll poll );
    Poll getPoll( Long pollId );
}
