package com.mani.springboot.os.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mani.springboot.os.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
