package com.example.labfx;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
public class PersonListWrapper {

    private List<Product> productList;

    @XmlElement(name = "product")
    public List<Product> getPersons() {
        return productList;
    }


    public void setPersons(List<Product> persons) {
        this.productList = persons;
    }
}