package com.cg.stockapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.stockapp.entities.Company;
import com.cg.stockapp.entities.Manager;
import com.cg.stockapp.repository.ManagerRepository;
import com.cg.stockapp.service.ManagerService;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class ManagerServiceTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private ManagerService managerService;

	@MockBean
	private ManagerRepository managerRepository;


	@Test
    @DisplayName("Test for retriving all Manager Details")
	public void getAllManager() {
    	
    		Mockito.when(managerRepository.findAll())
		.thenReturn(Stream.of(new Manager(),new Manager()).collect(Collectors.toList()));
		
		assertEquals(2, managerService.getAllManager().size());
		verify(managerRepository, times(1)).findAll();
		
	}      
	
	
	@Test
@DisplayName("Test for adding manager")
public void addManagerServiceTest() {
		Company c=new Company("Amzn","Amazon","NSE");
	Manager manager = new Manager("1","Surajit","Sm@gmail.com","sm@123","9876543210",c);
	when(managerRepository.save(manager)).thenReturn(manager);
	assertEquals(true, managerService.addManager(manager));
}
	
	@Test
@DisplayName("Test for updating manager")
	public void updateManagerTest() {
Company c=new Company("Amzn","Amazon","NSE");
	Manager manager = new Manager("1","Surajit","Sm@gmail.com","sm@123","9876543210", c);
	manager.setManagerName("Surendra");
    assertThat(managerRepository.findById(manager.getManagerId())).isNotEqualTo(manager);
	}

	@Test
	@DisplayName("Test for deleting manager")
	public void deleteManagerTest() {
Company c=new Company("Amzn","Amazon","NSE");
	Manager manager = new Manager("1","Surajit","Sm@gmail.com","sm@123","9876543210", c);
	when(managerRepository.existsById(manager.getManagerId())).thenReturn(true);
    managerService.deleteManager(manager.getManagerId());
    verify(managerRepository).deleteById("1");
	}

	
	@Test
	@DisplayName("Test for get manager details by Id")
	public void getManagerDetailsTest() {
Company c=new Company("Amzn","Amazon","NSE");
	Manager manager = new Manager("1","Surajit","Sm@gmail.com","sm@123","9876543210", c);
	 when(managerRepository.save(manager)).thenReturn(manager);
     assertNotEquals(manager,managerRepository.findById(manager.getManagerId()));

	}
	
/*	@Test
	@DisplayName("Test for get manager details by Company Id")
	public void getManagerTest() {
Company c=new Company("Amzn","Amazon","NSE");
	Manager manager = new Manager("1","Surajit","Sm@gmail.com","sm@123","9876543210", c);
	 when(managerRepository.save(manager)).thenReturn(manager);
     assertNotEquals(manager,managerRepository.findById(manager.getCompanyId()));

	}
	
	*/

}
