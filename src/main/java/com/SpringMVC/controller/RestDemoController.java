package com.SpringMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringMVC.DAO.SpringDemoRepo;
import com.SpringMVC.model.SprngMVCDemo;
//@Controller
@RestController
public class RestDemoController {
	
	@Autowired
	SpringDemoRepo springDemoRepo;
	
	//@GetMapping("models")
	@GetMapping(path="models",produces= {"application/xml"})
	//@ResponseBody
	public List getModel()
	{	
		List<SprngMVCDemo> model=springDemoRepo.findAll();
	//return model.toString();
		return model;
	}
	@GetMapping("model/{id}")
//	@ResponseBody - you can use directly rest cotroller instead of menion this everyewhere it will default have resposebody
	//public Optional<SprngMVCDemo> getMol(@PathVariable(name="id") int id)
	public SprngMVCDemo getMol(@PathVariable(name="id") int id)
	{
		//SprngMVCDemo sprg= springDemoRepo.getOne(id);
		//Optional<SprngMVCDemo> sprg1=	springDemoRepo.findById(id);
		SprngMVCDemo sprg=springDemoRepo.findById(id).orElse(new SprngMVCDemo(0,""));
	//m.addAttribute("result", sprngMVCDemodDAO.getMod(id));
	//return spring.toString();
	return sprg;
	}
	//@PostMapping("model")
	//@@PostMapping(path="model", consumes= {MediaType.APPLICATION_XML_VALUE})
	@PostMapping(path="model", consumes= {"application/json"})
	//public  SprngMVCDemo addModel( SprngMVCDemo  sprngMVCDemo ) - this will also work
	public  SprngMVCDemo addModel(@RequestBody SprngMVCDemo  sprngMVCDemo )
	{
		return springDemoRepo.save(sprngMVCDemo);
	}
	@DeleteMapping("model/{id}")
	public String deleteData(@PathVariable(name="id") int id)
	{
		springDemoRepo.deleteById(id);
		return "Removed success";
	}
	@PutMapping("model/{id}")
	public SprngMVCDemo updateData(@PathVariable(name="id") int id, @RequestBody SprngMVCDemo updatedData)
	{
    	SprngMVCDemo sprngMVCDemo=springDemoRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    	sprngMVCDemo.setName(updatedData.getName());
    	return springDemoRepo.save(sprngMVCDemo);
    	//return "Success";
	}
}
