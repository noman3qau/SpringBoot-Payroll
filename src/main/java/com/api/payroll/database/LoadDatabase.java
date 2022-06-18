package com.api.payroll.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.payroll.common.Status;
import com.api.payroll.models.Employee;
import com.api.payroll.models.Orders;
import com.api.payroll.repository.EmployeeRepository;
import com.api.payroll.repository.OrderRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {

		return args -> {
			employeeRepository.save(new Employee("Bilbo", "burglar"));
			employeeRepository.save(new Employee("Frodo", "thief"));

			employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

			orderRepository.save(new Orders("MacBook Pro", Status.COMPLETED));
			orderRepository.save(new Orders("iPhone", Status.IN_PROGRESS));

			orderRepository.findAll().forEach(order -> {
				log.info("Preloaded " + order);
			});
		};

	}
}
