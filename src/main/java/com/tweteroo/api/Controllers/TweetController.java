package com.tweteroo.api.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.DTOs.TweetDTO;
import com.tweteroo.api.Models.TweetModel;
import com.tweteroo.api.Services.TweetService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tweets")
public class TweetController {

    final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping()
    public ResponseEntity<List<TweetModel>> getTweets(String param) {
        List<TweetModel> tweets = tweetService.findTweets();

        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getTweetsById(@PathVariable("userId") Long userId) {
        Optional<List<TweetModel>> tweets = tweetService.findTweetsById(userId);

        if (tweets.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The user does not exist.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(tweets);
    }

    @PostMapping()
    public ResponseEntity<Object> postTweet(@RequestBody @Valid TweetDTO tweetDTO) {
        Optional<TweetModel> tweet = tweetService.createTweet(tweetDTO);

        if (tweet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The user does not exist.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
    }

}
