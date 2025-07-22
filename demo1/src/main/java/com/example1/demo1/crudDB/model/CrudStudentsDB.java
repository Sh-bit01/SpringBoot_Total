package com.example1.demo1.crudDB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CrudStudentsDB {

    @Id
    public int rollno;
    private String name;
    private  int age;

    public CrudStudentsDB() {}

    public CrudStudentsDB(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentsData{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
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


}
