package com.veritas.xml;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.sasanka.data.DataStore;

import development.FilesSortAndDelete;

import java.io.StringReader;
import java.io.StringWriter;

public class XMLReshape2 {

    public static void main(String[] args) {
        String sourceXml = "";
        String xslt = DataStore.xslt_cxml;

        sourceXml = FilesSortAndDelete.getContentOfFileAsTExt("C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\xcbl data\\UCDPO00068778.txt");
        
        
        
//        xslt = DataStore.xslt_ciw;
//        sourceXml = FilesSortAndDelete.getContentOfFileAsTExt("C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\xcbl data\\25095_ciw.txt");
        
        		
        
        try {
        	
        	System.out.println(xslt);
        	
            // Transform the XML
            String transformedXml = transformXml(sourceXml, xslt);

            // Output the transformed XML
            System.out.println("Transformed XML:");
            System.out.println(transformedXml);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private static String transformXml(String sourceXml, String xslt) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xsltSource = new StreamSource(new StringReader(xslt));
        Transformer transformer = factory.newTransformer(xsltSource);

        Source text = new StreamSource(new StringReader(sourceXml));
        StringWriter writer = new StringWriter();
        transformer.transform(text, new StreamResult(writer));

        return writer.toString();
    }
}
