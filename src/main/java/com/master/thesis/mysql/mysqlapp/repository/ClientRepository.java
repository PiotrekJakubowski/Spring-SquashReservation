package com.master.thesis.mysql.mysqlapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.master.thesis.mysql.mysqlapp.entity.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

}
