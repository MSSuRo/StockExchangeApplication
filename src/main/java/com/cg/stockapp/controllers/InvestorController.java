package com.cg.stockapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.stockapp.dto.Investor;
import com.cg.stockapp.service.InvestorSerive;

@RestController
@RequestMapping("/investor")
public class InvestorController {
	
	@Autowired
	InvestorSerive serv;
	
	@GetMapping
	public List<Investor> getAllInvestor() {
		return serv.getAllInvestor();
	}
	
}
