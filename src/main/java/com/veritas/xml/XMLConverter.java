package com.veritas.xml;




import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.*;
import java.util.*;

public class XMLConverter {

    private static Map<String, String> mappings = new HashMap<>();

    static {
        mappings.put("cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/PostalAddress/PostalCode", 
                     "PurchaseOrder/OrderHeader/OrderParty/ShipToParty/Party/NameAddress/PostalCode");
        mappings.put("cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/PostalCode", 
                     "PurchaseOrder/OrderHeader/OrderParty/BillToParty/Party/NameAddress/PostalCode");
        mappings.put("cXML/Request/OrderRequest/OrderRequestHeader/Total/Money/currency", 
                     "PurchaseOrder/OrderHeader/@OrderCurrency");
    }

    public static void main(String[] args) throws Exception {
    	String firstXmlPath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\veritas_data\\cxml_data\\UCDPO00068778_cxml_veritas.txt";
    	String secondXmlPath = "C:\\Users\\Sasanka_Talukder\\OneDrive - Dell Technologies\\Documents\\GitHub\\Veritas\\story related\\xcbl po\\veritas_data\\cxml_data\\UCDPO00068778_cxml_veritas_convert.txt";

    	File inputFile = new File(firstXmlPath);
    	File outputFile = new File(secondXmlPath);


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document inputDoc = dBuilder.parse(inputFile);
        Document outputDoc = dBuilder.newDocument();

        Element rootElement = outputDoc.createElement("Root"); // Create a root element for the output document
        outputDoc.appendChild(rootElement);

        for (Map.Entry<String, String> entry : mappings.entrySet()) {
            String sourcePath = entry.getKey();
            String targetPath = entry.getValue();

            NodeList sourceNodes = getNodeListByPath(inputDoc, sourcePath);
            for (int i = 0; i < sourceNodes.getLength(); i++) {
                Node sourceNode = sourceNodes.item(i);
                String value = getNodeTextContent(sourceNode);
                createNodeByPath(outputDoc, targetPath, value, sourceNode);
            }
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(outputDoc);
        StreamResult streamResult = new StreamResult(outputFile);
        transformer.transform(domSource, streamResult);
    }

    private static NodeList getNodeListByPath(Document doc, String path) throws Exception {
        XPath xPath = XPathFactory.newInstance().newXPath();
        return (NodeList) xPath.evaluate(path.replaceAll("/@", "/@*"), doc, XPathConstants.NODESET);
    }

    private static void createNodeByPath(Document doc, String path, String value, Node sourceNode) {
        String[] parts = path.split("/");
        Node currentNode = doc.getDocumentElement(); // Start from the root element
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.startsWith("@")) {
                ((Element) currentNode).setAttribute(part.substring(1), value);
                return;
            } else {
                NodeList nodeList = ((Element) currentNode).getElementsByTagName(part);
                if (nodeList.getLength() == 0) {
                    Element newElement = doc.createElement(part);
                    currentNode.appendChild(newElement);
                    currentNode = newElement;
                } else {
                    currentNode = nodeList.item(0);
                }
            }
        }
        setNodeTextContent(currentNode, value);

        // Handle attributes in the source path
        if (sourceNode.getNodeType() == Node.ELEMENT_NODE) {
            NamedNodeMap attributes = sourceNode.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                Attr attr = (Attr) attributes.item(j);
                ((Element) currentNode).setAttribute(attr.getName(), attr.getValue());
            }
        }
    }

    private static String getNodeTextContent(Node node) {
        StringBuilder textContent = new StringBuilder();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node child = childNodes.item(i);
            if (child.getNodeType() == Node.TEXT_NODE) {
                textContent.append(child.getNodeValue());
            }
        }
        return textContent.toString();
    }

    private static void setNodeTextContent(Node node, String value) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node child = childNodes.item(i);
            if (child.getNodeType() == Node.TEXT_NODE) {
                child.setNodeValue(value);
                return;
            }
        }
        Node textNode = node.getOwnerDocument().createTextNode(value);
        node.appendChild(textNode);
    }
}
