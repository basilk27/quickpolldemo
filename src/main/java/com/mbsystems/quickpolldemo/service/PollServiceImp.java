package com.mbsystems.quickpolldemo.service;

import com.mbsystems.quickpolldemo.entities.Poll;
import com.mbsystems.quickpolldemo.exceptions.RecordNotFoundException;
import com.mbsystems.quickpolldemo.repository.PollRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollServiceImp implements PollService {

    private final PollRepository pollRepository;

    public PollServiceImp(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    @Override
    public List<Poll> getAllPolls() {
        return this.pollRepository.findAll();
    }

    @Override
    public Poll createPoll(Poll poll) {
        return this.pollRepository.save( poll );
    }

    @Override
    public Poll getPoll(Long pollId) {
        Optional<Poll> optionalPoll = this.pollRepository.findById( pollId );

        return optionalPoll.orElseThrow(() -> new RecordNotFoundException("Invalid ID : " + pollId) );
    }
}
