package com.imemyself.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.imemyself.course.domain.Order;
import com.imemyself.course.service.OrderService;

@RestController
@RequestMapping(value = "/Orders")
public class OrderResource {

	@Autowired
	private OrderService OrderService;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> listOrder = OrderService.findAll();
		return ResponseEntity.ok().body(listOrder);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order Order = OrderService.findById(id);
		return ResponseEntity.ok().body(Order);
	}
}
