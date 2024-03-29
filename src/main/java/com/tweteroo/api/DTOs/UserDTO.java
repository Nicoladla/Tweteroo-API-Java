package com.tweteroo.api.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "The field cannot be empty")
    private String avatar;

    @NotBlank(message = "The field cannot be empty")
    @Size(max = 100, min = 3, message = "The name must be greater than 4 characters and less than 100 characters")
    private String username;
}
