package com.example.SpringSecurityThird.service;

import com.example.SpringSecurityThird.autoDTO.ClotheDTO;
import com.example.SpringSecurityThird.hendler.PersonNotFoundException;
import com.example.SpringSecurityThird.model.Clothe;
import com.example.SpringSecurityThird.repositoriy.RepositoriyClothe;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClotheImpl implements ServiceClothe  {
        @Autowired
    private RepositoriyClothe repositoriyClothe;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void add(ClotheDTO clotheDTO) {
        Clothe clothe = objectMapper.convertValue(clotheDTO, Clothe.class);
        repositoriyClothe.save(clothe);
    }

    @Override
    public List<Clothe> findAll() {
        return repositoriyClothe.findAll();
    }

    @Override
    public void delete(int id) {
    if (repositoriyClothe.findById(id).isPresent()){
        repositoriyClothe.deleteById(id);
    }
    throw new PersonNotFoundException("пользователя с таким id не найдено");
    }
}
