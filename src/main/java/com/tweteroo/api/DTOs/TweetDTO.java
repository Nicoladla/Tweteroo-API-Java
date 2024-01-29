package com.tweteroo.api.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {

    @NotBlank(message = "The field cannot be empty")
    @Size(min = 4, max = 280, message = "The tweet must be no longer than 280 characters and no shorter than 4 characters")
    private String text;

    @Positive(message = "The id must be greater than 0")
    @NotNull
    private Long userId;
}
