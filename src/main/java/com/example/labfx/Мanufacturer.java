package com.example.labfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Мanufacturer {

    private final StringProperty name;
    private final StringProperty country;
    private final StringProperty contact_person;
    private final StringProperty phone;

    public Мanufacturer(){
        this(null,null,null,null);
    }

    public Мanufacturer(String name,String country,String contact_person,String phone) {
        this.name = new SimpleStringProperty(name);
        this.country = new SimpleStringProperty(country);
        this.contact_person = new SimpleStringProperty(contact_person);
        this.phone = new SimpleStringProperty(phone);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getContact_person() {
        return contact_person.get();
    }

    public void setContact_person(String contact_person) {
        this.contact_person.set(contact_person);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public StringProperty countryProperty() {
        return country;
    }

    public StringProperty contactPersonProperty() {
        return contact_person;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty phoneProperty() {
        return phone;
    }
}
