package com.veritas.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sasanka.data.DataStore;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class XmlPathFinder {

	private static int foundCount = 0;

	private static String myString = "";

	public static void main(String[] args) throws Exception {

		processCXMLData();
//		processciwXMLData();

	}

	private static void processCXMLData() {

		String xcblFilePath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\xcbl data\\UCDPO00068778.txt";
		String xmlFilePath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\veritas_data\\cxml_data\\UCDPO00068778_cxml_veritas.txt";

		
		String[] xmlPathsDS = DataStore.xmlPaths;

		String parentPathCxml = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\veritas_data\\cxml_data";
    	
		Set<String> commonMapping = XmlValueExtractor.extractCommonMappingxml(parentPathCxml,xmlPathsDS);

		processXMLData(xmlPathsDS, commonMapping, xcblFilePath, xmlFilePath);

	}

	private static void processciwXMLData() {
		String parentPath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\xcbl data";

		
		String xcblFilePath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\xcbl data\\DE62707665.txt";
		String xmlFilePath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\veritas_data\\ciw_data\\DE62707665_ciw_veritas.txt";

		String[] xmlPathsDS = DataStore.ciwxmlPaths;

		String parentPathCxml = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\veritas_data\\ciw_data";
    	
		Set<String> commonMapping = XmlValueExtractor.extractCommonMappingxml(parentPathCxml,xmlPathsDS);

		processXMLData(xmlPathsDS, commonMapping, xcblFilePath, xmlFilePath);

	}

	private static void processXMLData(String[] xmlPathsDS, Set<String> commonMapping, String xcblFilePath,
			String xmlFilePath) {

		try {
			for (String xmlPath : xmlPathsDS) {
				myString += xmlPath + ",\n";
			}

			Document xcblDoc = parseXML(xcblFilePath);
			Document xmlDoc = parseXML(xmlFilePath);

			Set<String> xcblValues = getAllValues(xcblDoc);
			Set<String> xmlValues = getAllValues(xmlDoc);

			Set<String> commonValues = new HashSet<>(xcblValues);
			commonValues.retainAll(xmlValues);

			System.out.println("commonValues size : " + commonValues.size());

			System.out.println("Common values and their paths:");

			Set<String> finalMappings = new HashSet<>();

			for (String value : commonValues) {
//			    System.out.println("Value: " + value);
//			    System.out.println("Paths in xcbl.xml:");
				JSONArray xcblPaths = getPaths(xcblDoc, value);
//			    System.out.println(xcblPaths.get(0));
//			    System.out.println("Paths in xml.xml:");
				JSONArray xmlPaths = getPaths(xmlDoc, value);
//			    System.out.println(xmlPaths.get(0));

				if(xcblPaths.length() > 0 && xmlPaths.length() > 0) {
					String xmlPath0 = xmlPaths.getString(0).substring(1, xmlPaths.getString(0).length());
					String xcblPath0 = xcblPaths.getString(0).substring(1, xcblPaths.getString(0).length());
					boolean isPathPresentinMapper = checkPathPresent(xmlPaths.getString(0));

					String oneRowValue = xmlPath0 + "," + xcblPath0;
					if (commonMapping.contains(xmlPath0)) {
						oneRowValue += ",M";
					} else {
						oneRowValue += ",O";
					}

					if (isPathPresentinMapper) {
						finalMappings.add(oneRowValue);
					}
				}
			}
//			System.out.println("myString :: \n" + myString );
			System.out.println("foundCount : " + foundCount);
			System.out.println("finalMappings size : " + finalMappings.size());

			JSONArray pathList = XmlValueExtractor.getAllFoundMappingXML(xmlPathsDS, xmlFilePath);
			System.out.println("pathList length: " + pathList.length());

			String finalDataxcblXmlPAth = "XML path,xcbl Path,Priority,Data Availability,\n";
			for (String oneCS : finalMappings) {
//        	System.out.println(oneCS);
				finalDataxcblXmlPAth += oneCS + "\n";
			}

			for (int i = 0; i < pathList.length(); i++) {
//				System.out.println(finalDataxcblXmlPAth.contains(pathList.getString(i) +","));
				if (!finalDataxcblXmlPAth.contains(pathList.getString(i) + ",")) {
					finalDataxcblXmlPAth += pathList.getString(i) + ",";
					if (commonMapping.contains(pathList.getString(i))) {
						finalDataxcblXmlPAth += ",M" + "\n";
					} else {
						finalDataxcblXmlPAth += ",O" + "\n";
					}

				}
			}
			
			
			for (String oneXmlPath : xmlPathsDS) {
				if (!finalDataxcblXmlPAth.contains(oneXmlPath + ",")) {
					finalDataxcblXmlPAth += oneXmlPath + ",,O,Data Not present\n";
				}
			}
			
			System.out.println("finalDataxcblXmlPAth : \n" + finalDataxcblXmlPAth);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Document parseXML(String filePath) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(new File(filePath));
	}

	private static Set<String> getAllValues(Document doc) throws Exception {
		Set<String> values = new HashSet<>();
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();

		// Get all text node values
		XPathExpression textExpr = xpath.compile("//text()");
		NodeList textNodes = (NodeList) textExpr.evaluate(doc, XPathConstants.NODESET);
		for (int i = 0; i < textNodes.getLength(); i++) {
			String value = textNodes.item(i).getNodeValue();
			if (value != null) {
				value = value.trim();
				if (!value.isEmpty()) {
					values.add(value);
				}
			}
		}

		// Get all attribute values
		XPathExpression attrExpr = xpath.compile("//@*");
		NodeList attrNodes = (NodeList) attrExpr.evaluate(doc, XPathConstants.NODESET);
		for (int i = 0; i < attrNodes.getLength(); i++) {
			String attrValue = attrNodes.item(i).getNodeValue();
			if (attrValue != null) {
				attrValue = attrValue.trim();
				if (!attrValue.isEmpty()) {
					values.add(attrValue);
				}
			}
		}

		return values;
	}

	private static JSONArray getPaths(Document doc, String value) throws Exception {

		JSONArray allPathList = new JSONArray();

		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();

		// Find paths for elements with matching text values
		String exprStr = String.format("//*[text()='%s']", value);
		XPathExpression elemExpr = xpath.compile(exprStr);
		NodeList elemNodes = (NodeList) elemExpr.evaluate(doc, XPathConstants.NODESET);
		for (int i = 0; i < elemNodes.getLength(); i++) {
			allPathList.put(getNodePath(elemNodes.item(i), false));
		}

		// Find paths for attributes with matching values
		exprStr = String.format("//@*[.='%s']", value);
		XPathExpression attrExpr = xpath.compile(exprStr);
		NodeList attrNodes = (NodeList) attrExpr.evaluate(doc, XPathConstants.NODESET);
		for (int i = 0; i < attrNodes.getLength(); i++) {
			allPathList.put(getNodePath(attrNodes.item(i), true));
		}
		return allPathList;
	}

	private static String getNodePath(Node node, boolean isAttribute) {
		if (node == null) {
			return null;
		}

		StringBuilder path = new StringBuilder();
		if (isAttribute && node.getNodeType() == Node.ATTRIBUTE_NODE) {
			path.append("/").append(node.getNodeName());
			node = ((Attr) node).getOwnerElement();
		}

		while (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
			path.insert(0, "/" + node.getNodeName());
			node = node.getParentNode();
		}

//        System.out.println(path.toString());
		readLineAndCompare(path.toString());
		return path.toString();
	}

//    private static void readLineAndCompare(String pathToCheck) {
////    	System.out.println("pathToCheck : " + pathToCheck);
//    	pathToCheck = pathToCheck.substring(1,pathToCheck.length());
//    	System.out.println("pathToCheck : " + pathToCheck);
//		Scanner scanner = new Scanner(myString);
//    	while (scanner.hasNextLine()) {
//    	  String line = scanner.nextLine();
////    	  System.out.println(line.contains(pathToCheck));
////    	  System.out.println("line :::"+ line);
//    	  if(line.contains(pathToCheck)) {
//    		  line += ",found";
//    		  System.out.println("line :"+ line);
//    		  break;
//    	  }
//    	  // process the line
//    	}
//    	scanner.close();
//    }

	public static String readLineAndCompare(String pathToCheck) {
		try {
			String paragraph = myString;
			pathToCheck = pathToCheck.substring(1, pathToCheck.length());
			pathToCheck = pathToCheck + ",";
//        	System.out.println("pathToCheck : " + pathToCheck);
			// Use BufferedReader to read line by line
			BufferedReader reader = new BufferedReader(new StringReader(paragraph));
			StringWriter outWriter = new StringWriter();
			PrintWriter writer = new PrintWriter(outWriter);

			String line;

			while ((line = reader.readLine()) != null) {
				String editedLine = line;
				if (line.contains(pathToCheck)) {
//          		  line += ",found";

					// Edit each line here (for example, add "Edited: " prefix)
					if (!line.contains(",found")) {
						editedLine = line + ",found";
						foundCount++;
					}

//                  System.out.println("editedLine :"+ editedLine);

					// Write the edited line to output
//                  writer.println(editedLine);

//          		  break;
				}
				writer.println(editedLine);

			}

			// Close resources
			reader.close();
			writer.close();

			// Get the edited paragraph as a String
			myString = outWriter.toString();
			return outWriter.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean checkPathPresent(String pathToCheck) {
		try {
			String paragraph = myString;
			pathToCheck = pathToCheck.substring(1, pathToCheck.length());
			pathToCheck = pathToCheck + ",";
			if (paragraph.contains(pathToCheck)) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
}
