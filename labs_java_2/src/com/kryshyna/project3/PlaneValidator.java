/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project3;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

/**
 *
 * @author Kryshyna Vadym
 */
public class PlaneValidator {
    public static void validate(String fileXsd, String fileXml) {
        boolean result = false;
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(fileXsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(fileXml)));
            result = true;
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        if(result == true){
            System.out.println("Vlidate is OK.");
        }else{
            System.out.println("Not validate. Wrong xml file.");
        }
    }
        
}
