package com.example.SpringSecurityThird.controler;

import com.example.SpringSecurityThird.autoDTO.ClotheDTO;
import com.example.SpringSecurityThird.hendler.PersonNotFoundException;
import com.example.SpringSecurityThird.model.Clothe;
import com.example.SpringSecurityThird.service.ServiceClotheImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/clothe")
@AllArgsConstructor
public class ControlerClothe {

    @Autowired
    private ServiceClotheImpl serviceClothe;


    @PostMapping("/add")
    public void add(@RequestBody @Valid ClotheDTO clotheDTO, BindingResult bindingResult) {
        log.info("мы в методе add");
        if (bindingResult.hasErrors()) {
            throw new PersonNotFoundException("возникла ошибка");
        }
        serviceClothe.add(clotheDTO);
        log.info("clothe успешно добавлен");
    }
    @GetMapping("/findclothe")
    public List<Clothe> findAll() {
        log.info("мы в методе findall");
        return serviceClothe.findAll();
    }
    @DeleteMapping("/deleteclothe/{id}")
    public void delete(@PathVariable  int id) {
        log.info("мы в методе delete");
        serviceClothe.delete(id);
    }
}
