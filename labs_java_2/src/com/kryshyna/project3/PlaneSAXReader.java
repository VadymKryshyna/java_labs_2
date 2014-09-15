/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project3;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Kryshyna Vadym
 */
public class PlaneSAXReader extends DefaultHandler {
    private Plane plane;
    private Chars chars;
    private Parameters parameters;
    private int current = -1;
    
    public Plane getPlane(String fileXml) {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(fileXml, this);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
        return plane;
   }

    @Override
    public void startDocument() { System.out.println("Parsing started"); }

    @Override
    public void endDocument(){System.out.println("Parsing finished");}

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        switch(qName){
            case "plane": plane = new Plane(); break;
            case "model": current = 1; break;
            case "origin": current = 2; break;
            case "chars": chars = new Chars();
                          chars.setId(Integer.parseInt(attrs.getValue(0)));
                          current = 3; break;
            case "type": current = 4; break;
            case "seat": current = 5; break;
            case "arming": current = 6; break;
            case "rockets": current = 7; break;
            case "radar": current = 8; break;
            case "parameters": parameters = new Parameters(); current = 9; break;
            case "length": current = 10; break;
            case "height": current = 11; break;
            case "width": current = 12; break;
            case "price": current = 13; break;
        }
    }
 
    @Override
    public void endElement(String uri, String localName, String qName){ 
        current = -1;
    }

    @Override
    public void characters(char[] ch, int start, int length) {    
        String s = new String(ch, start, length);
        try{
            switch (current) {
                case 1: plane.setModel(s); break;
                case 2: plane.setOrigin(s); break;
                case 3: plane.setChars(chars); break;
                case 4: chars.setType(s); break;
                case 5: chars.setSeat(Integer.parseInt(s)); break;
                case 6: chars.setArming(s); break;
                case 7: chars.setRockets(Integer.parseInt(s)); break;
                case 8: chars.setRadar(s); break;
                case 9: plane.setParameters(parameters); break;
                case 10: parameters.setLength(Integer.parseInt(s)); break;
                case 11: parameters.setHeight(Integer.parseInt(s)); break;
                case 12: parameters.setWidth(Integer.parseInt(s)); break;
                case 13: plane.setPrice(Double.parseDouble(s)); break;
            }
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
}
