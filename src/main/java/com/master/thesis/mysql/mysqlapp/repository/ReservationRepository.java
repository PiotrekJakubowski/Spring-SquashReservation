package com.master.thesis.mysql.mysqlapp.repository;

import com.master.thesis.mysql.mysqlapp.entity.Client;
import com.master.thesis.mysql.mysqlapp.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
}
