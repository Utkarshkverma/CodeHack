package com.vermau2k01.coderhack.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank(message = "Name is mandatory")
    String name;

}
