package com.api.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.payroll.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
