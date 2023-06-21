package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Tourist;

public interface repository extends JpaRepository<Tourist, Integer> {

	@Query("DELETE From Tourist WHERE tid between :start AND :end")
	@Modifying
	public int deleteAllByRange(Integer start, Integer end);

	@Query("update Tourist set budget=:newbudget where tid BETWEEN :start AND :end")
	@Modifying
	public int updateByIdRange(Integer start, Integer end, Double newbudget);

}