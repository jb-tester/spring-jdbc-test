package com.mytests.spring.springjdbctest.embeddableModel;

/**
 * *
 * <p>Created by irina on 28.06.2021.</p>
 * <p>Project: spring-jdbc-test</p>
 * *
 */
public class CustomerAddress {
    String city;
    String street;
    int building;
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

}
