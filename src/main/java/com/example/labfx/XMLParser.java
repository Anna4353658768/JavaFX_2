package com.example.labfx;

import javafx.collections.ObservableList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParser {

    public void parseProduct(ObservableList<Product> products,File file){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList nodeList = document.getElementsByTagName("product");

            for (int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                Product product = new Product("",0f,0f,0f,0f,"","","","");
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    product.setName(element.getElementsByTagName("name").item(1).getTextContent());
                    product.setWeight(Float.parseFloat(element.getElementsByTagName("weight").item(0).getTextContent()));

                    product.getSize().setWidth(Float.parseFloat(element.getElementsByTagName("width").item(0).getTextContent()));
                    product.getSize().setLength(Float.parseFloat(element.getElementsByTagName("length").item(0).getTextContent()));
                    product.getSize().setHeight(Float.parseFloat(element.getElementsByTagName("height").item(0).getTextContent()));

                    product.getМanufacturer().setName(element.getElementsByTagName("name").item(0).getTextContent());
                    product.getМanufacturer().setCountry(element.getElementsByTagName("country").item(0).getTextContent());
                    product.getМanufacturer().setContact_person(element.getElementsByTagName("contact_person").item(0).getTextContent());
                    product.getМanufacturer().setPhone(element.getElementsByTagName("phone").item(0).getTextContent());
                }
                products.add(product);
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }


    }


}
