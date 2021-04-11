package com.cg.stockapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.stockapp.entities.Manager;
import com.cg.stockapp.exceptions.DuplicateManagerException;
import com.cg.stockapp.exceptions.EmptyTableException;
import com.cg.stockapp.exceptions.ManagerNotFoundException;
import com.cg.stockapp.repository.ManagerRepository;





@Service
public class ManagerServiceImpl implements ManagerService {
	
	
	

		@Autowired
		ManagerRepository repo;
		
		
		@Override
		public boolean addManager(Manager man) {
			if (repo.existsById(man.getManagerId()))
				throw new DuplicateManagerException("Manager already exists with id " + man.getManagerId());
			else {
				repo.save(man);
				return true;
			}
		}


		@Override
		public List<Manager> getAllManager() {

			if(repo.findAll().isEmpty())
				throw new EmptyTableException("No Data Found in the database");
			else
				return repo.findAll();
		}
		
		@Override
		public Manager updateManager(Manager man) {
			return repo.save(man);
		}
		
		@Override
		public boolean deleteManager(Manager man) {
			if (repo.existsById(inv.getManagerId())) {
				repo.delete(man);
				return true;
			}
			else
				throw new ManagerNotFoundException("Manager not found with id " + inv.getManagerId());
		}

	}
	
	
	
	
	
	

