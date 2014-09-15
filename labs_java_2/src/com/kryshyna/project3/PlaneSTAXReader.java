/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Kryshyna Vadym
 */
public class PlaneSTAXReader {

    public static Plane parseFromFile(String fileXml){
        Plane plane = null;
        Chars chars = null;
        Parameters parameters = null;
        FileInputStream file = null;
        try {
            String tagContent = null;
            XMLInputFactory factory = XMLInputFactory.newInstance();
            file = new FileInputStream(fileXml);
            XMLStreamReader reader= factory.createXMLStreamReader(file);
                    //ClassLoader.getSystemResourceAsStream(fileXml));
            while(reader.hasNext()){
                int event = reader.next();
                switch(event){
                    case XMLStreamConstants.START_ELEMENT:
                        if("plane".equals(reader.getLocalName())){
                            plane = new Plane();
                        }else if("chars".equals(reader.getLocalName())){
                            chars = new Chars();
                            chars.setId(Integer.parseInt(reader.getAttributeValue(0)));
                            plane.setChars(chars);
                        }else if("parameters".equals(reader.getLocalName())){
                            parameters = new Parameters();
                            plane.setParameters(parameters);
                        }
                        break;
                        
                    case XMLStreamConstants.CHARACTERS:
                        tagContent = reader.getText().trim();
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        switch(reader.getLocalName()){
                            case "model": plane.setModel(tagContent); break;
                            case "origin": plane.setOrigin(tagContent); break;
                            case "type" : chars.setType(tagContent); break;
                            case "seat": chars.setSeat(Integer.parseInt(tagContent)); break;
                            case "arming": chars.setArming(tagContent); break;
                            case "rockets": chars.setRockets(Integer.parseInt(tagContent)); break;
                            case "radar": chars.setRadar(tagContent); break;
                            case "length": parameters.setLength(Integer.parseInt(tagContent)); break;
                            case "height": parameters.setHeight(Integer.parseInt(tagContent)); break;
                            case "width": parameters.setWidth(Integer.parseInt(tagContent)); break;
                            case "price": plane.setPrice(Double.parseDouble(tagContent)); break;
                        }; break;
                }
            }
        } catch (XMLStreamException ex) {
            Logger.getLogger(PlaneSTAXReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PlaneSTAXReader.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (file!=null){
                try {
                    file.close();
                } catch (IOException ex) {
                    Logger.getLogger(PlaneSTAXReader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return plane;
    }
}
