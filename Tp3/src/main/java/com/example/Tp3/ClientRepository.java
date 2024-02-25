package com.example.Tp3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface ClientRepository extends JpaRepository<Client,Long> {
        }