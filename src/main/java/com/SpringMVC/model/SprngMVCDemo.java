package com.SpringMVC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SprngMVCDemo {
	@Id
	private int id;
	private String name;
	//private String positiom;
	public int getId() {
		return id;
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
    public SprngMVCDemo() {}

    public SprngMVCDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
