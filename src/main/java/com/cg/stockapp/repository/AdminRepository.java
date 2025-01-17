package com.cg.stockapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.stockapp.dto.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

}
