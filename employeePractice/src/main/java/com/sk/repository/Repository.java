package com.sk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.entity.Employee;

public interface Repository extends JpaRepository<Employee,Integer> {

}
