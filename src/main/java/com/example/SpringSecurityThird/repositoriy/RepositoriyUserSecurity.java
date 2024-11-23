package com.example.SpringSecurityThird.repositoriy;

import com.example.SpringSecurityThird.model.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoriyUserSecurity extends JpaRepository <UserSecurity, Integer> {
    Optional <UserSecurity>  findByUserName(String username);
}
