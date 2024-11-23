package com.example.SpringSecurityThird.autoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class AutotintecationDTO {
    @Size(min = 2, max = 20)
    @NotBlank
    private String userName;
    @Size(min = 2, max = 2000)
    @NotBlank
    private String password;
}
