package com.example.labfx;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Product {

    private final StringProperty name;
    private final FloatProperty weight;

    @XmlElement(required = true)
    private final Size size;

    @XmlElement(required = true)
    private final Мanufacturer мanufacturer;

    public Product(String name,Float weight,Float length,Float width,Float height,String nameM,String country,String contact,String phone){
        this.name = new SimpleStringProperty(name);
        this.weight = new SimpleFloatProperty(weight);
        this.size = new Size(length,width,height);
        this.мanufacturer = new Мanufacturer(nameM,country,contact,phone);
    }

    public Product(String name,Float weight,Size size,Мanufacturer мanufacturer){
        this.name = new SimpleStringProperty(name);
        this.weight = new SimpleFloatProperty(weight);
        this.size = size;
        this.мanufacturer = мanufacturer;
    }

    public Product(String name,Float weight,Float length,Float width,Float height, Мanufacturer мanufacturer){
        this.name = new SimpleStringProperty(name);
        this.weight = new SimpleFloatProperty(weight);
        this.size = new Size(length,width,height);
        this.мanufacturer = мanufacturer;
    }

    public Product(){
        this(null,null,null,null);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public float getWeight() {
        return weight.get();
    }

    public FloatProperty weightProperty() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight.set(weight);
    }

    public Size getSize() {
        return size;
    }

    public Мanufacturer getМanufacturer() {
        return мanufacturer;
    }




}
