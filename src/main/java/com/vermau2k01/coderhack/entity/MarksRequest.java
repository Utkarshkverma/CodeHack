package com.vermau2k01.coderhack.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class MarksRequest {
    @Min(value = 0, message = "Marks cannot be negetive")
    @Max(value = 100, message = "Marks cannot exceed 100")
    int marks;

}
