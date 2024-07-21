package com.SpringMVC.controller;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringMVC.DAO.SpringDemoRepo;
import com.SpringMVC.DAO.SprngMVCDemodDAO;
import com.SpringMVC.model.SpringMVCModel;
import com.SpringMVC.model.SprngMVCDemo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	SpringDemoRepo springDemoRepo;
	@Autowired
	SprngMVCDemodDAO sprngMVCDemodDAO;
	@RequestMapping("add")
	public String addMethod(@RequestParam("num1")int i,@RequestParam("num2") int j, ModelMap m)
	{

		int result=i+j;
		
		m.addAttribute("result",result);
		return "result";
	}
	//ModelAttribte on method level
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("name","sprngMVCDemos");
		
	}
	@RequestMapping("/")
	public String home()
	{
		System.out.println("Home page requested");
		//return "index";
		
		return "index";
	}
	
	@RequestMapping("addModelAnother")
	public String addMod(@ModelAttribute("result") SprngMVCDemo springMVCdemo)
	{
		springDemoRepo.save(springMVCdemo);
		//sprngMVCDemodDAO.addModelAnother(springMVCdemo);
		return "showSpringMVCData";
	}
	@PostMapping(value="addModel")//sending data
	//public String addMethod(@ModelAttribute SpringMVCModel springMVCdemo)
	public String addMethod(@ModelAttribute SpringMVCModel springMVCdemo,Model m)
//	public String addMethod(@ModelAttribute("result") SpringMVCModel springMVCModel )//Model m)
	//public String addMethod(SpringMVCModel s )//Model m)
	{
//For public String addMethod(@ModelAttribute SpringMVCModel springMVCModel , Model m) -> m.addAttribute("result",springMVCModel);
		m.addAttribute("result",springMVCdemo);
		return "result";
	}
    @GetMapping("updateModel")
    public String updateModel(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name, Model m) {
    	//sprngMVCDemodDAO.updateModel(id, name);
    	SprngMVCDemo sprngMVCDemo=springDemoRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    	sprngMVCDemo.setName(name);
    	springDemoRepo.save(sprngMVCDemo);
        // Set the success message in the model
        m.addAttribute("successMessage", "Entity with ID " + id + " updated successfully.");

        return "sucess";
    }
    //findall
	@GetMapping("getModels")
	public String getModel(Model m)
	{
		//Normalway
	//List<SprngMVCDemo>	spring=Arrays.asList(new SpringMVCModel(1,"Roopa"), new SpringMVCModel(2,"Sam"));
	//using traditional approach hbernate
		//m.addAttribute("result", sprngMVCDemodDAO.getModels());
		m.addAttribute("result", springDemoRepo.findAll());
		
	//return spring.toString();
	return "showSpringMVCData";
	}

	@GetMapping("getMol")
	public String getMol(@RequestParam(name="id") int id, Model m)
	{
		m.addAttribute("result", springDemoRepo.getOne(id));
		m.addAttribute("result", springDemoRepo.findById(id));
	//m.addAttribute("result", sprngMVCDemodDAO.getMod(id));
	//return spring.toString();
	return "showSpringMVCData";
	}
	@GetMapping("getMolByName")
	public String getMolByName(@RequestParam(name="name") String name, Model m)
	{

		//m.addAttribute("result", springDemoRepo.findByName(name));
		//m.addAttribute("result", springDemoRepo.findByNameOrderByName(name));
		m.addAttribute("result", springDemoRepo.find(name));
	return "showSpringMVCData";
	}
    @GetMapping("/deleteAllEntities")
    public String deleteAllEntities() {
        
        // Call service method to delete all entities
    	//sprngMVCDemodDAO.deleteAllEntities();
//    	List<SpringDemo> entities = springDemoRepo.findAll();
//
//    	// Deletes each entity in the list
//    	springDemoRepo.deleteAll(entities);
    	springDemoRepo.deleteAll();
        return "sucess";  // Redirect to a success page or list page
    }
    @GetMapping("/deleteEntity")
    public String deleteEntity(@RequestParam(name="id") int id, RedirectAttributes redirectAttributes, Model model) {
        
        // Call service method to delete the entity
    //	sprngMVCDemodDAO.deleteEntity(id);
    	springDemoRepo.deleteById(id);
    	
    	 model.addAttribute("successMessage", "Entity with ID " + id + " deleted successfully.");
        //redirectAttributes.addFlashAttribute("message", "ID " + id + " removed successfully.");

        // Redirect to a success page or list page
        return "sucess";
    }

}
