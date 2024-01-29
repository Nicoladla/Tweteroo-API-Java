package com.tweteroo.api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tweteroo.api.Models.TweetModel;
import com.tweteroo.api.Repositories.TweetRepository;

@Service
public class TweetService {
    final TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public List<TweetModel> findTweets() {
        return tweetRepository.findAll();
    }
}
