package com.veritas.xml;

//String firstXmlPath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\veritas_data\\cxml_data\\UCDPO00068778_cxml_veritas.txt";

//String secondXmlPath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\veritas_data\\cxml_data\\UCDPO00068778_cxml_veritas_convert.txt";

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XMLTransformer {

	public static void main(String[] args) throws Exception {
//        String firstXmlPath = "path/to/first.xml"; // Replace with your first XML file path
//        String secondXmlPath = "path/to/second.xml"; // Replace with your second XML file path

		String firstXmlPath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\veritas_data\\cxml_data\\UCDPO00068778_cxml_veritas.txt";
		String secondXmlPath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\veritas_data\\cxml_data\\UCDPO00068778_cxml_veritas_convert.txt";

		System.out.println("new File(secondXmlPath).delete() :: " + new File(secondXmlPath).delete());

		String mapping = "cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/PostalAddress/PostalCode,"
				+ "PurchaseOrder/OrderHeader/OrderParty/ShipToParty/Party/NameAddress/PostalCode\n"
				+ "cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/PostalCode,"
				+ "PurchaseOrder/OrderHeader/OrderParty/BillToParty/Party/NameAddress/PostalCode\n"
				+ "cXML/Request/OrderRequest/OrderRequestHeader/Total/Money/@currency,"
				+ "PurchaseOrder/OrderHeader/@OrderCurrency\n"
				+ "cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/Street,"
				+ "PurchaseOrder/OrderHeader/OrderParty/ShipToParty/Party/NameAddress/PostalCode\n"
				+ "cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/State,"
				+ "PurchaseOrder/OrderHeader/OrderParty/ShipToParty/Party/NameAddress/PostalCode\n"
				+ "cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/State,"
				+ "PurchaseOrder/OrderHeader/OrderParty/ShipToParty/Party/NameAddress/PostalCode\n"
				+ "cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/State,"
				+ "PurchaseOrder/OrderHeader/OrderParty/ShipToParty/Party/NameAddress/PostalCode\n"
				+ "cXML/Request/OrderRequest/OrderRequestHeader/Extrinsic/@name,"
				+ "PurchaseOrder/Extrinsic/Extrinsic/@Name\n"
				+ "cXML/Request/OrderRequest/ItemOut/ItemID/SupplierPartID,"
				+ "PurchaseOrder/ItemOut/ItemID/SupplierPartID\n"
				+ "cXML/Request/OrderRequest/OrderRequestHeader/BillTo,"
				+ "PurchaseOrder/OrderHeader/OrderParty/ShipToParty/Party/NameAddress/PostalCode";

//        Map<String, String> pathMapping = parseMapping(mapping);
		convertXML(firstXmlPath, secondXmlPath, mapping);
	}

	private static void convertXML(String firstXmlPath, String secondXmlPath, String mapping) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Parse the first XML
		Document firstDoc = builder.parse(firstXmlPath);

		// Create or replace the second XML document
		Document secondDoc = createOrReplaceDocument(secondXmlPath);

		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xPath = xPathFactory.newXPath();

//        for (Map.Entry<String, String> entry : pathMapping.entrySet()) {

		String[] lines = mapping.split("\n");
		for (String line : lines) {
			String[] paths = line.split(",");
			if (paths.length == 2) {
				String firstPath = paths[0].trim();
				String secondPath = paths[1].trim();

				// Split the secondPath to handle the last node separately
				String[] secondPathParts = secondPath.split("/");
				boolean isLastNodeAttribute = secondPathParts[secondPathParts.length - 1].startsWith("@");

				// Find the value in the first XML
				XPathExpression firstExpr = xPath.compile(firstPath);
				NodeList firstNodes = (NodeList) firstExpr.evaluate(firstDoc, XPathConstants.NODESET);

				// Find or create the destination node in the second XML
				Node secondNode = (Node) xPath.compile(secondPath).evaluate(secondDoc, XPathConstants.NODE);
				if (secondNode == null) {
					// Create the path in the second document if it does not exist
					secondNode = createPath(secondDoc, secondPath);
				}

				for (int i = 0; i < firstNodes.getLength(); i++) {
					Node firstNode = firstNodes.item(i);
					System.out.println(secondPath + " == secondPathParts0 : " + secondNode.getNodeName());
					System.out.println(firstPath + " == secondPathParts0 : " + firstNode.getNodeName());

					if (firstNode != null && secondNode != null) {
						if (isLastNodeAttribute) { // Last node is an attribute in the target
							String attrName = secondPathParts[secondPathParts.length - 1].substring(1); // Get attribute
																										// name
							String value = getNodeValue(firstNode);
							System.out.println(secondPath + " == secondPathParts1 : " + value);
							if (secondNode.getNodeType() == Node.ELEMENT_NODE) {
								Element secondElement = (Element) secondNode;
//								System.out.println("secondElement.getAttribute(\"attrName\"); : "
//										+ (secondElement.getAttribute("fdfdf") == ""));

								if (secondElement.getAttribute(attrName) != "") {
									Element appendCurrentElement = (Element) secondElement.getParentNode();
									Element newChild = secondDoc.createElement(secondElement.getNodeName());
//									newChild.appendChild(tempNode);
									newChild.setAttribute(attrName, value);
									appendCurrentElement.appendChild(newChild);
								} else {
									secondElement.setAttribute(attrName, value);
								}

							}
						} else if (firstPath.startsWith("@")) { // Source is an attribute
							String attrValue = firstNode.getNodeValue();
							System.out.println(firstPath + " == secondPathParts2 : " + attrValue);
							if (secondNode.getNodeType() == Node.ELEMENT_NODE) {
								Element secondElement = (Element) secondNode;
								// If the last part is not an attribute, set text content
								System.out.println(
										secondPath + " == secondPathParts002 : " + secondElement.hasChildNodes());
//                        while (secondElement.hasChildNodes()) {
//                            secondElement.removeChild(secondElement.getFirstChild());
//                        }

								if (secondElement.hasChildNodes()) {
									Element appendCurrentElement = (Element) secondElement.getParentNode();
									Element newChild = secondDoc.createElement(secondElement.getNodeName());
									newChild.appendChild(secondDoc.createTextNode(attrValue));
									appendCurrentElement.appendChild(newChild);
								} else {
									secondElement.appendChild(secondDoc.createTextNode(attrValue));
								}
							}
						} else { // Both are elements
							if (secondNode.getNodeType() == Node.ELEMENT_NODE) {
								Element secondElement = (Element) secondNode;
								// Use a temporary node to set text
								Node tempNode = secondDoc.createTextNode(getNodeValue(firstNode));
								// Remove existing children and append new text node
								System.out
										.println(firstPath + " == secondPathParts2 : " + secondElement.hasChildNodes());
								System.out.println("secondElement ::" + secondElement.getNodeName() + "--"
										+ secondElement.getNodeValue());
								if (secondElement.hasChildNodes()) {
									Element appendCurrentElement = (Element) secondElement.getParentNode();
									Element newChild = secondDoc.createElement(secondElement.getNodeName());
									newChild.appendChild(tempNode);
									appendCurrentElement.appendChild(newChild);
								} else {
									secondElement.appendChild(tempNode);
								}
								System.out.println(secondPath + " == secondPathParts3 : " + tempNode.getNodeValue());
							}
						}
					}

				}

			}
		}
//        }

		// Save the modified second XML with pretty print
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty("indent", "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "4"); // Set indentation level
		DOMSource source = new DOMSource(secondDoc);
		StreamResult result = new StreamResult(secondXmlPath); // Output file path
		transformer.transform(source, result);

		System.out.println("XML conversion completed.");
	}

	private static Document createOrReplaceDocument(String xmlPath) throws Exception {
		File xmlFile = new File(xmlPath);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc;
		if (xmlFile.exists()) {
			// If the file exists, parse it
			doc = builder.parse(xmlFile);
			System.out.println(xmlFile.getName() + " Replaced");
		} else {
			// If the file does not exist, create a new document
			doc = builder.newDocument();
			// Create a root element (adjust as needed)
			Element root = doc.createElement("PurchaseOrder"); // Change to your desired root element
			doc.appendChild(root);
			System.out.println(xmlFile.getName() + " Created");
		}
		return doc;
	}

	private static Node createPath(Document doc, String path) {
		String[] nodes = path.split("/");
		Element currentElement = (Element) doc.getDocumentElement();
		for (String nodeName : nodes) {
			if (nodeName.startsWith("@")) {
				// Handle attributes separately, skipping since attributes cannot create nodes
				continue;
			}
			System.out.println(nodeName);
			System.out.println(currentElement.getElementsByTagName(nodeName).getLength());
			Node childNode = currentElement.getElementsByTagName(nodeName).item(0);
			if (childNode == null) {
				// Create the new element
				Element newElement = doc.createElement(nodeName);
				currentElement.appendChild(newElement);
				currentElement = newElement;
			} else {
				currentElement = (Element) childNode;
			}
		}
		return currentElement;
	}

	private static String getNodeValue(Node node) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			StringBuilder value = new StringBuilder();
			// If the node has child nodes, concatenate their values
			for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
				value.append(child.getNodeValue());
			}
			return value.toString();
		} else if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
			return node.getNodeValue();
		}
		return null;
	}

//    private static void convertXML(String firstXmlPath, String secondXmlPath, Map<String, String> pathMapping) throws Exception {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//
//        // Parse the first XML
//        Document firstDoc = builder.parse(firstXmlPath);
//
//        // Create or replace the second XML document
//        Document secondDoc = createOrReplaceDocument(secondXmlPath);
//
//        XPathFactory xPathFactory = XPathFactory.newInstance();
//        XPath xPath = xPathFactory.newXPath();
//
//        for (Map.Entry<String, String> entry : pathMapping.entrySet()) {
//            String firstPath = entry.getKey();
//            String secondPath = entry.getValue();
//
//            // Split the secondPath to handle the last node separately
//            String[] secondPathParts = secondPath.split("/");
//            boolean isLastNodeAttribute = secondPathParts[secondPathParts.length - 1].startsWith("@");
//
//            // Find the value in the first XML
//            XPathExpression firstExpr = xPath.compile(firstPath);
//            Node firstNode = (Node) firstExpr.evaluate(firstDoc, XPathConstants.NODE);
//
//            // Find or create the destination node in the second XML
//            Node secondNode = (Node) xPath.compile(secondPath).evaluate(secondDoc, XPathConstants.NODE);
//            if (secondNode == null) {
//                // Create the path in the second document if it does not exist
//                secondNode = createPath(secondDoc, secondPath);
//            }
//
//            System.out.println(secondPath + " == secondPathParts0 : " +secondNode.getNodeName());
//            
//            if (firstNode != null && secondNode != null) {
//                if (isLastNodeAttribute) { // Last node is an attribute in the target
//                    String attrName = secondPathParts[secondPathParts.length - 1].substring(1); // Get attribute name
//                    String value = getNodeValue(firstNode);
//                    System.out.println(secondPath + " == secondPathParts1 : " +value);
//                    if (secondNode.getNodeType() == Node.ELEMENT_NODE) {
//                        Element secondElement = (Element) secondNode;
//                        secondElement.setAttribute(attrName, value);
//                    }
//                } else if (firstPath.startsWith("@")) { // Source is an attribute
//                    String attrValue = firstNode.getNodeValue();
//                    System.out.println(firstPath + " == secondPathParts2 : " +attrValue);
//                    if (secondNode.getNodeType() == Node.ELEMENT_NODE) {
//                        Element secondElement = (Element) secondNode;
//                        // If the last part is not an attribute, set text content
//                        while (secondElement.hasChildNodes()) {
//                            secondElement.removeChild(secondElement.getFirstChild());
//                        }
//                        secondElement.appendChild(secondDoc.createTextNode(attrValue));
//                    }
//                } else { // Both are elements
//                    if (secondNode.getNodeType() == Node.ELEMENT_NODE) {
//                        Element secondElement = (Element) secondNode;
//                        // Use a temporary node to set text
//                        Node tempNode = secondDoc.createTextNode(getNodeValue(firstNode));
//                        // Remove existing children and append new text node
//                        while (secondElement.hasChildNodes()) {
//                            secondElement.removeChild(secondElement.getFirstChild());
//                        }
//                        System.out.println(secondPath + " == secondPathParts3 : " +tempNode.getNodeName());
//                        secondElement.appendChild(tempNode);
//                    }
//                }
//            }
//        }
//
//     // Save the modified second XML with pretty print
//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        Transformer transformer = transformerFactory.newTransformer();
//        transformer.setOutputProperty("indent", "yes");
//        transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "4"); // Set indentation level
//        DOMSource source = new DOMSource(secondDoc);
//        StreamResult result = new StreamResult(secondXmlPath); // Output file path
//        transformer.transform(source, result);
//        
//        System.out.println("XML conversion completed.");
//    }

//    private static Map<String, String> parseMapping(String mapping) {
//        Map<String, String> pathMapping = new HashMap<>();
//        String[] lines = mapping.split("\n");
//        for (String line : lines) {
//            String[] paths = line.split(",");
//            if (paths.length == 2) {
//                pathMapping.put(paths[0].trim(), paths[1].trim());
//            }
//        }
//        System.out.println("pathMapping :: " + new Gson().toJson(pathMapping));
//        return pathMapping;
//    }

}
