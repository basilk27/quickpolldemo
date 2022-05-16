package com.mbsystems.quickpolldemo.controller;

import com.mbsystems.quickpolldemo.entities.Poll;
import com.mbsystems.quickpolldemo.service.PollServiceImp;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class PollController {

    private final PollServiceImp pollServiceImp;

    public PollController(PollServiceImp pollServiceImp) {
        this.pollServiceImp = pollServiceImp;
    }

    @GetMapping(value = "/polls", produces = "application/json")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return new ResponseEntity<>( this.pollServiceImp.getAllPolls(), HttpStatus.OK );
    }

    @PostMapping( value = "/polls", produces = "application/json")
    public ResponseEntity<?> createPoll(@RequestBody Poll poll ) {
        poll = this.pollServiceImp.createPoll( poll );

        HttpHeaders responseHeaders = new HttpHeaders();

        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                                                    .path( "/{id}" )
                                                    .buildAndExpand( poll.getId() )
                                                    .toUri();

        responseHeaders.setLocation( newPollUri );

        return new ResponseEntity<>( poll, responseHeaders, HttpStatus.CREATED );
    }

    @GetMapping( value = "/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId ) {
        Poll poll = this.pollServiceImp.getPoll( pollId );

        return new ResponseEntity<>( poll, HttpStatus.OK );
    }
}
