package com.example.labfx;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Size{

    private final FloatProperty length;
    private final FloatProperty width;
    private final FloatProperty height;

    public Size(Float length,Float width,Float height) {
        this.length = new SimpleFloatProperty(length);
        this.width = new SimpleFloatProperty(width);
        this.height = new SimpleFloatProperty(height);

    }

    public Size() {
        this(null,null,null);
    }


    public float getLength() {
        return length.get();
    }

    public FloatProperty lengthProperty() {
        return length;
    }

    public void setLength(float length) {
        this.length.set(length);
    }

    public float getWidth() {
        return width.get();
    }

    public FloatProperty widthProperty() {
        return width;
    }

    public void setWidth(float width) {
        this.width.set(width);
    }

    public float getHeight() {
        return height.get();
    }

    public FloatProperty heightProperty() {
        return height;
    }

    public void setHeight(float height) {
        this.height.set(height);
    }
}
