package com.viktor.phonebook;

import java.io.Serializable;

public class Person implements Serializable {

    private int id;
    private String firstname, lastname, address, phone, mail, date, title;
    private  Zipcode zipcode;

    public Person(){}

    public Person(String firstname, String lastname, String address, Zipcode zipcode,String phone, String mail, String date, String title) {
        this(0, firstname, lastname, address, zipcode, phone, mail, date, title);
    }

    public Person(int id, String firstname, String lastname, String address, Zipcode zipcode, String phone, String mail, String date, String title) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.zipcode = zipcode;
        this.phone = phone;
        this.mail = mail;
        this.date = date;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Zipcode getZipcode() {
        return zipcode;
    }

    public void setZipcode(Zipcode zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString()
    {
        return firstname + " " + lastname;
    }
}