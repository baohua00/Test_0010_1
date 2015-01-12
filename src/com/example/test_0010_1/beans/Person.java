package com.example.test_0010_1.beans;

public class Person {
	public int _id;  
    public String name;  
    public String password;  
    public String info;
    
    public Person() {  
    }
    
    public Person(String name, String password) {  
    	this.name = name;
    	this.password = password;
    	this.info = "NO INFO";
    }
      
    public Person(String name, String password, String info) {  
        this.name = name;  
        this.password = password;  
        this.info = info;
    }
}
