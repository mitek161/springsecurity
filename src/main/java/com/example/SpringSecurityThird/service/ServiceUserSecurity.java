package com.example.SpringSecurityThird.service;

import com.example.SpringSecurityThird.autoDTO.RegistrationDTO;
import com.example.SpringSecurityThird.hendler.PersonNotFoundException;
import com.example.SpringSecurityThird.model.Role;
import com.example.SpringSecurityThird.model.UserSecurity;
import com.example.SpringSecurityThird.repositoriy.RepositoriyUserSecurity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServiceUserSecurity implements ServiceUser {
    @Autowired
    private RepositoriyUserSecurity repositoriyUserSecurity;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void registrSave(RegistrationDTO registrationDTO) {
    log.info("мы в методе registrSave");
        if (repositoriyUserSecurity.findByUserName(registrationDTO.getUserName()).isPresent()){
            log.info("возникла ошибка в методе registrSave");
            throw new PersonNotFoundException("такой логин уже есть");
        }
        UserSecurity userSecurity = objectMapper.convertValue(registrationDTO, UserSecurity.class);
        userSecurity.setPassword(passwordEncoder.encode(userSecurity.getPassword()));
        userSecurity.setRole(Role.USER);
        repositoriyUserSecurity.save(userSecurity);
    }

}
