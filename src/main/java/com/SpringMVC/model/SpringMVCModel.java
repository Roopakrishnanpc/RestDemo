package com.SpringMVC.model;

public class SpringMVCModel {
	private int id;
	private String name;
	//private String positiom;
    public SpringMVCModel() {
    }
	public int getId() {
		return id;
	}
	public SpringMVCModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SpringMVCModel [id=" + id + ", name=" + name + "]";
	}
	
}
