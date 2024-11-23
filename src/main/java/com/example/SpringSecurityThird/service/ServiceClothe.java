package com.example.SpringSecurityThird.service;

import com.example.SpringSecurityThird.autoDTO.ClotheDTO;
import com.example.SpringSecurityThird.model.Clothe;

import java.util.List;

public interface ServiceClothe  {
    void add(ClotheDTO clotheDTO);

    List<Clothe> findAll();

    void delete(int id);

}
