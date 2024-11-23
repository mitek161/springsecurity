package com.example.SpringSecurityThird.repositoriy;

import com.example.SpringSecurityThird.model.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoriyClothe extends JpaRepository<Clothe,Integer> {


}
