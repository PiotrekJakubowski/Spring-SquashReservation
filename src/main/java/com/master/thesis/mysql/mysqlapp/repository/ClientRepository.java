package com.master.thesis.mysql.mysqlapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.master.thesis.mysql.mysqlapp.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{

}
