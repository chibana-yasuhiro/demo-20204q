package com.example.demo20204q.Form;

public class PersonForm {

    
    public PersonForm(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    private int id;
    
    private String name;
    
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
