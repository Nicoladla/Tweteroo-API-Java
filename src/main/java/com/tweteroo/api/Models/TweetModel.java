package com.tweteroo.api.Models;

import com.tweteroo.api.DTOs.TweetDTO;
import com.tweteroo.api.DTOs.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tweets")
public class TweetModel {

    public TweetModel(TweetDTO tweetDTO) {
        this.text = tweetDTO.getText();
    }

    public TweetModel(TweetDTO tweetDTO, UserModel user) {
        this.text = tweetDTO.getText();
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 280)
    private String text;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserModel user;
}
