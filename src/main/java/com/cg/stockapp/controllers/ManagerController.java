package com.cg.stockapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.stockapp.entities.Investor;
import com.cg.stockapp.service.InvestorSerive;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@PostMapping("/manager")
	public String addManager(@RequestBody Manager man) {
		managerService.addManager(man);
		return "Manager added successfully";
		
	}
	
	@GetMapping
	public List<Manager> getAllManager() {

		return managerService.getAllManager();
		
	}
	
	@UpdateMapping
	public String updateManager(@RequestBody Manager man) {
		managerService.updateManager(man);
		return "Manager updated successfully";
	
	}
	
	
	
	
	@DeleteMapping
	public String deleteManager(@RequestBody Manager man) {
		managerService.deleteManager(man);
		return "Manager with id "+man.getManagerId()+" successfully deleted";
	}
	
	
}






