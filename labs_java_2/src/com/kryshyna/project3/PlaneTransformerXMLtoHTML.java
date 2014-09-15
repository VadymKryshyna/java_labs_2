/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project3;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Kryshyna Vadym
 */
public class PlaneTransformerXMLtoHTML {
    public static void transform(String fileXsl, String fileXml, String fileHtml) {
        try {
            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer transformer = tFact.newTransformer(new StreamSource(fileXsl)); //"notepad.xsl"
            transformer.transform(new StreamSource(fileXml), new StreamResult(fileHtml));   //"notepad.xml" "notepad.html"
        } catch (TransformerException e){ 
            e.printStackTrace(); 
        }
    }
}
