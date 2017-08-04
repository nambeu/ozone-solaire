package com.paperjais.ozone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paperjais.ozone.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
