package com.api.payroll.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.payroll.common.Status;
import com.api.payroll.exceptions.OrderNotFoundException;
import com.api.payroll.models.Orders;
import com.api.payroll.repository.OrderRepository;

@RestController
public class OrderController {

	private final OrderRepository repository;

	OrderController(OrderRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/orders")
	public List<Orders> all() {
		return repository.findAll();
	}

	@PostMapping("/orders")
	Orders newOrder(@RequestBody Orders newOrder) {
		return repository.save(newOrder);
	}

	@GetMapping("/orders/{id}")
	Orders one(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
	}

	@PutMapping("/orders/{id}")
	Orders replaceOrder(@RequestBody Orders newOrder, @PathVariable Long id) {

		return repository.findById(id).map(order -> {
			order.setDescription(newOrder.getDescription());
			order.setStatus(newOrder.getStatus());
			return repository.save(order);
		}).orElseGet(() -> {
			newOrder.setId(id);
			return repository.save(newOrder);
		});
	}

	@DeleteMapping("/orders/{id}")
	void deleteOrder(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@DeleteMapping("/orders/{id}/cancel")
	Orders cancel(@PathVariable Long id) {

		Orders order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

		if (order.getStatus() == Status.IN_PROGRESS) {
			order.setStatus(Status.CANCELLED);
		}

		return repository.save(order);
	}

	@PutMapping("/orders/{id}/complete")
	Orders complete(@PathVariable Long id) {

		Orders order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

		if (order.getStatus() == Status.IN_PROGRESS) {
			order.setStatus(Status.COMPLETED);
		}

		return repository.save(order);
	}

}
