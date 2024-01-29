package com.tweteroo.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.Models.TweetModel;

@Repository
public interface TweetRepository extends JpaRepository<TweetModel, Long> {

}
