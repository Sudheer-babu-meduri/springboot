package com.example.springbootactuators.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springbootactuators.model.Cricketer;
import com.example.springbootactuators.repo.CrickRepo;

@Service
public class CrickService {

	@Autowired
	CrickRepo crickrepo;
	
	 //Insert Cricketer
	public Cricketer insert(@RequestBody Cricketer crick) {
		return crickrepo.save(crick); 
	}
	
	public Cricketer update(Cricketer cricketer) {
		return crickrepo.save(cricketer);
	}
	
	public Cricketer getById(int id) {
		return crickrepo.findById(id).orElseThrow(()->new RuntimeException("ID "+id+" Not Found"));
	}
	
	 public String delete(int id) {
		 if(crickrepo.findById(id)!=null) {
			 crickrepo.deleteById(id);
		 return "jersy "+id+" has been deleted ";
		 }else 
			 return "Jersy "+id+" Not Found";
		 
	 }
	 public List<Cricketer> getAll(){
		 return crickrepo.findAll();
	 }
	 
}
