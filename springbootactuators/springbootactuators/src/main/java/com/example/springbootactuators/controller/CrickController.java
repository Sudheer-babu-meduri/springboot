package com.example.springbootactuators.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootactuators.model.Cricketer;
import com.example.springbootactuators.service.CrickService;

@RestController
public class CrickController {

	@Autowired
	CrickService service;
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	@GetMapping("/getall")
	public List<Cricketer> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/insert")
	public Cricketer insert(@RequestBody Cricketer cricketer) {
		return service.insert(cricketer);
	}
	
	@PutMapping("/update{id}")
	public Cricketer update(@PathVariable("id") int id,@RequestBody Cricketer cricketer) {
		Cricketer crick = service.getById(id);
		crick.setName(cricketer.getName());
		crick.setIccrank(cricketer.getIccrank());
		return service.update(crick);
		
	}
	@GetMapping("/get{id}")
	public Cricketer get(@PathVariable("id") int id) {
		return service.getById(id);
	}
	
	@DeleteMapping("delete{id}")
	public String delete(@PathVariable("id") int id) {
		return service.delete(id);
	}
}
