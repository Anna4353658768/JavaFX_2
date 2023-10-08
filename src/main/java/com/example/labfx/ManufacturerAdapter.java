package com.example.labfx;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ManufacturerAdapter  extends XmlAdapter<String, Мanufacturer> {


    @Override
    public Мanufacturer unmarshal(String v) throws Exception {
        return null;
    }

    @Override
    public String marshal(Мanufacturer v) throws Exception {
        return v.toString();
    }
}
