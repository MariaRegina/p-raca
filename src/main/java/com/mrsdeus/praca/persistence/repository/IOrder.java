package com.mrsdeus.praca.persistence.repository;

import com.mrsdeus.praca.persistence.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IOrder extends JpaRepository<Order, UUID>{
}
