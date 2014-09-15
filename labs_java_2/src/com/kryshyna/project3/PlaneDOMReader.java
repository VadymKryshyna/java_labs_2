/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project3;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author Kryshyna Vadym
 */
public class PlaneDOMReader {
    private static String getValue(Element e, String name) {
        NodeList nList = e.getElementsByTagName(name);
        Element elem = (Element) nList.item(0);
        Text t= (Text) elem.getFirstChild();
        return t.getNodeValue(); 
    }
    
    public static Plane parse(String fileXml) {
        Plane e = null;
        Document doc = null;
        DOMParser parser = new DOMParser();
        try {
            parser.parse(fileXml);
            doc = parser.getDocument();
            Element root = doc.getDocumentElement();
            e = new Plane();
            e.setModel(getValue(root, "model"));
            e.setOrigin(getValue(root, "origin"));
            Element n = (Element)root.getElementsByTagName("chars").item(0);
            Chars ch = new Chars();
            ch.setId(Integer.parseInt(n.getAttributes().item(0).getNodeValue()));
            ch.setType(getValue(n, "type"));
            ch.setSeat(Integer.parseInt(getValue(n, "seat")));
            ch.setArming(getValue(n, "arming"));
            ch.setRockets(Integer.parseInt(getValue(n, "rockets")));
            ch.setRadar(getValue(n, "radar"));
            e.setChars(ch);
            Parameters p = new Parameters();
            Element n1 = (Element)root.getElementsByTagName("parameters").item(0);
            p.setLength(Integer.parseInt(getValue(n1, "length")));
            p.setHeight(Integer.parseInt(getValue(n1, "height")));
            p.setWidth(Integer.parseInt(getValue(n1, "width")));
            e.setParameters(p);
            e.setPrice(Double.parseDouble(getValue(root, "price")));
        } catch (SAXException | IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }
        return e;
    }
}