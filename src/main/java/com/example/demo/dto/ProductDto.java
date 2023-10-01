package com.example.demo.dto;

import com.example.demo.annotation.CustomConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    @NotBlank
    @CustomConstraint
    private String name;

    @NotBlank
    private String option;

}
