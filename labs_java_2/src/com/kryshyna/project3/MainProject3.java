/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kryshyna.project3;

/**
 *
 * @author Kryshyna Vadym
 */
public class MainProject3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileXml = "plane1.xml";
        String fileXsl = "plane1.xsl";
        String fileXsd = "plane1.xsd";
        String fileHtml = "plane1.html";
        
        //transformation
        PlaneTransformerXMLtoHTML.transform(fileXsl, fileXml, fileHtml);
        
        //validation
        PlaneValidator.validate(fileXsd, fileXml);
        
        //DOM parsing
        Plane plane = PlaneDOMReader.parse(fileXml);
        System.out.println(plane);
        
        //SAX parsing
        PlaneSAXReader planeSAX = new PlaneSAXReader();
        Plane plane1 = planeSAX.getPlane(fileXml);
        System.out.println(plane1);
        
        //STAX parsing
        Plane plane2 = PlaneSTAXReader.parseFromFile(fileXml);
        System.out.println(plane2);
    }
    
}
