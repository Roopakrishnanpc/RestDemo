package com.SpringMVC.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.SpringMVC.model.SprngMVCDemo;

public interface SpringDemoRepo extends JpaRepository<SprngMVCDemo,Integer>{

	List<SprngMVCDemo> findByName(String name); //Query DSL -> Domain Specific lanugauge depending on what name we have jpa will create our own method. But we can't create unrelevant methods
	//eg: GetBy<variable_name> or FindBy<variable_name> 
	//we can also give FindBy<variable_name>OrderByName
	List<SprngMVCDemo> findByNameOrderByName(String name);
	List<SprngMVCDemo> findByNameOrderByIdDesc(String name);
	
	//query annotation
	@Query("from SprngMVCDemo where name= :name")
	List<SprngMVCDemo> find(@Param("name")String name); 

}
