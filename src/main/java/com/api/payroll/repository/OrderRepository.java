package com.api.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.payroll.models.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
