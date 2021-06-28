package com.mytests.spring.springjdbctest.embeddableModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

/**
 * *
 * <p>Created by irina on 16.06.2021.</p>
 * <p>Project: spring-jdbc-test</p>
 * *
 */
public class EmbeddableCustomer {
    @Id Integer id;
    String firstname;
    String lastname;
    String birthday;
    int credit;
    boolean vip;
    int card;
    @Embedded.Empty(prefix = "mobile")
    CustomerPhone mphone;
    @Embedded.Empty(prefix="home")
    CustomerPhone hphone;
    
    @Embedded.Nullable()
    CustomerAddress address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    
    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public CustomerAddress getAddress() {
        return address;
    }

    public void setAddress(CustomerAddress address) {
        this.address = address;
    }

    public CustomerPhone getMphone() {
        return mphone;
    }

    public void setMphone(CustomerPhone mphone) {
        this.mphone = mphone;
    }

    public CustomerPhone getHphone() {
        return hphone;
    }

    public void setHphone(CustomerPhone hphone) {
        this.hphone = hphone;
    }

    @Override
    public String toString() {
        return "EmbeddableCustomer: "+ firstname +" "+ lastname;
    }
}
