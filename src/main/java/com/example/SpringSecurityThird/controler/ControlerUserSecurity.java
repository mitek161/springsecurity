package com.example.SpringSecurityThird.controler;

import com.example.SpringSecurityThird.autoDTO.AutotintecationDTO;
import com.example.SpringSecurityThird.autoDTO.RegistrationDTO;
import com.example.SpringSecurityThird.hendler.PersonNotFoundException;
import com.example.SpringSecurityThird.model.UserSecurity;
import com.example.SpringSecurityThird.service.ServiceUserSecurity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usersecurity")
@AllArgsConstructor
@Slf4j
public class ControlerUserSecurity {
    @Autowired
    private ServiceUserSecurity serviceUserSecurity;

    @Autowired
    private AuthenticationManager authenticationManagerBean;


    //для регистрации
    @PostMapping("/registrsave")
    public ResponseEntity<String> registrSave(@RequestBody @Valid RegistrationDTO registrationDTO, BindingResult bindingResult){
        log.info("мы в методе registrSave");
        if (bindingResult.hasErrors()){
            log.info("возникла ошибка в registrSave");
            throw new PersonNotFoundException("возникла ошибка при добавлении");
        }
        serviceUserSecurity.registrSave(registrationDTO);
        log.info("регистрация прощла успешно");
        return new ResponseEntity<>("ползователь успешно зарегестрирован",HttpStatus.ACCEPTED);
    }

   @PostMapping("/login")
    public void login(@RequestBody @Valid AutotintecationDTO autotintecationDTO, BindingResult bindingResult) {
        log.info("мы в методе login");
        if (bindingResult.hasErrors()){
            log.info("возникла ошибка в методе login");
            throw new PersonNotFoundException("введены не рпавильные данные");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(autotintecationDTO.getUserName(),autotintecationDTO.getPassword());
        try {
            authenticationManagerBean.authenticate(usernamePasswordAuthenticationToken);
        }catch (AuthenticationException authenticationException){
            System.out.println(authenticationException.getMessage());
        }
       log.info("аутунтификация прошла успешно");
   }
}
