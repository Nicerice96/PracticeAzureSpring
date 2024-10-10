package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String firstName;
    private String lastName;
    private Float weight;
    private Float height;

    public void setLongId(Long id){
        this.id = id;
    }
    public Long getLongId(){
        return this.id;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Float getWeight() {
        return this.weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return this.height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }



    Person(){}


    public Person(String firstName, String lastName, Float weight, Float height){

        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString(){
        return this.firstName + " : " + this.lastName + " : " + this.lastName + " : " + this.lastName;
    }



}