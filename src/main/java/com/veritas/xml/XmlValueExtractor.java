package com.veritas.xml;



import org.json.JSONArray;
import org.w3c.dom.*;

import com.sasanka.data.DataStore;
import com.sasanka.json.CommonStringsFinder;

import development.FilesSortAndDelete;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.File;
import java.util.List;
import java.util.Set;

public class XmlValueExtractor {

    public static void main(String[] args) throws Exception {

    	String parentPath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\veritas_data";
    	
    	extractCommonMappingxml(parentPath,DataStore.xmlPaths);
        
    }
    
    
    public static Set<String> extractCommonMappingxml(String parentPath,String[] mapperPath) {
    	
//        String xmlFilePath = parentPath + "\\UCDPO00068778_cxml_veritas.txt";
        
        List<String> fileAllPaths = FilesSortAndDelete.getAllPathsInsideDir(parentPath);
        
        
        // Example list of XML paths to check
        String[] xmlPaths = mapperPath;
        
//        String[] fileNames = {"5068547_cxml_veritas.txt",
//        		"17402094_cxml_veritas.txt",
//        		"68618439_cxml_veritas.txt",
//        		"103302906719_cxml_veritas.txt",
//        		"UCDPO00068778_cxml_veritas.txt",
//        		"PO002275_cxml_veritas.txt"};
        
        JSONArray allPathList = new JSONArray();
        for(String filePath : fileAllPaths) {
        	JSONArray pathList = getAllFoundMappingXML(xmlPaths, filePath);
        	allPathList.put(pathList);
        }
        
        Set<String> commonStrings = CommonStringsFinder.findCommonStrings(allPathList);
        System.out.println("Common strings length: " + commonStrings.size());
//        System.out.println("Common strings: " + commonStrings);
//        for(String oneCS : commonStrings) {
//        	System.out.println(oneCS);
//        }
        return commonStrings;
    }

    public static JSONArray getAllFoundMappingXML(String[] xmlPaths, String xmlFilePath) {
    	JSONArray pathList = new JSONArray();
        try {
			Document xmlDoc = parseXML(xmlFilePath);

			System.out.println("xmlPaths : " + xmlPaths.length);
			System.out.println("Checking XML paths and printing values:");
			int foundCount = 0,notFoundCount = 0;
			for (String path : xmlPaths) {
			    String value = getValueByPath(xmlDoc, path);
			    if (value != null) {
//                System.out.println(path + ": found - " + value);
//			    	System.out.println(path + ": found");
			    	pathList.put(path);
			    	foundCount++;
			    } else {
//			        System.out.println(path + ": Not found");
			        notFoundCount++;
			    }
			}
			System.out.println(xmlFilePath + "\nfoundCount - " + foundCount + ", notFoundCount - " + notFoundCount + "\n-------------------------------------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return pathList;
	}

	private static Document parseXML(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(filePath));
    }

    private static String getValueByPath(Document doc, String xpathStr) {
        try {
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expr = xpath.compile(xpathStr);
            Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
            if (node != null) {
                return getNodeTextContent(node).trim();
            }

            // Try as an attribute
            String attrXPathStr = xpathStr + "/@*";
            
            
            String[] inpt_arr = xpathStr.split("/");
            inpt_arr[inpt_arr.length - 1] = "@" + inpt_arr[inpt_arr.length - 1] ;
            attrXPathStr = String.join("/", inpt_arr);
            
//            System.out.println("attrXPathStr > " + attrXPathStr);
            XPathExpression attrExpr = xpath.compile(attrXPathStr);
            Node attrNode = (Node) attrExpr.evaluate(doc, XPathConstants.NODE);
            if (attrNode != null) {
                return attrNode.getNodeValue().trim();
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getNodeTextContent(Node node) {
        StringBuilder textContent = new StringBuilder();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node child = childNodes.item(i);
            if (child.getNodeType() == Node.TEXT_NODE || child.getNodeType() == Node.CDATA_SECTION_NODE) {
                textContent.append(child.getNodeValue());
            } else if (child.getNodeType() == Node.ELEMENT_NODE) {
                textContent.append(getNodeTextContent(child));
            }
        }
        return textContent.toString();
    }
}
