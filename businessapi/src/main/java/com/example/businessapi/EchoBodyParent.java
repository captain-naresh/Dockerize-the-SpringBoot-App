package com.example.businessapi;

public class EchoBodyParent {
 
    private long id;
     
    private String name;
     
    private int age;
     
    private double salary;
 
    public EchoBodyParent(){
        id=0;
    }
     
    public EchoBodyParent(long id, String name, int age, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
     
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    public double getSalary() {
        return salary;
    }
 
    public void setSalary(double salary) {
        this.salary = salary;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EchoBodyParent other = (EchoBodyParent) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "EchoBodyParent [id=" + id + ", name=" + name + ", age=" + age
                + ", salary=" + salary + "]";
    }
 
 
}