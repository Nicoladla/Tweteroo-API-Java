package com.tweteroo.api.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.Models.TweetModel;
import com.tweteroo.api.Services.TweetService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

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

}
