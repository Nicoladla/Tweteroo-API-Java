package com.tweteroo.api.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.DTOs.TweetDTO;
import com.tweteroo.api.Models.TweetModel;
import com.tweteroo.api.Models.UserModel;
import com.tweteroo.api.Repositories.TweetRepository;
import com.tweteroo.api.Repositories.UserRepository;

@Service
public class TweetService {
    final TweetRepository tweetRepository;
    final UserRepository userRepository;

    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public List<TweetModel> findTweets() {
        return tweetRepository.findAll();
    }

    public Optional<List<TweetModel>> findTweetsById(Long userId) {
        Optional<UserModel> user = userRepository.findById(userId);

        if (user.isEmpty())
            return Optional.empty();

        List<TweetModel> tweets= tweetRepository.findTweetsByUserId(userId);

        return Optional.of(tweets);
    }

    public Optional<TweetModel> createTweet(TweetDTO tweetDTO) {
        Optional<UserModel> user = userRepository.findById(tweetDTO.getUserId());

        if (user.isEmpty())
            return Optional.empty();

        TweetModel tweet = new TweetModel(tweetDTO, user.get());

        tweetRepository.save(tweet);

        return Optional.of(tweet);
    }

}
