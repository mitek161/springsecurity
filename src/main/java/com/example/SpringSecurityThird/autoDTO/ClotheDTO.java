package com.example.SpringSecurityThird.autoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class ClotheDTO {
    @Size(min = 2, max = 200)
    @NotBlank
    private String category;
    @Min(value = 10)
    @Max(value = 1000000)
    private Integer price;
    @Size(min = 1,max = 10000)
    @NotBlank
    private String color;
}
