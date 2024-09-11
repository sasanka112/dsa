package com.veritas.xml;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLReshape {

    public static void main(String[] args) {
        String sourceXml = "<Request>\r\n"
        		+ "                <OrderRequest>\r\n"
        		+ "                    <ItemOut quantity=\"1\" requestedDeliveryDate=\"2024-01-06\" lineNumber=\"100\">\r\n"
        		+ "                        <ItemID>\r\n"
        		+ "                            <SupplierPartID>300000986459\\\\1</SupplierPartID>\r\n"
        		+ "                        </ItemID>\r\n"
        		+ "                        <ItemDetail>\r\n"
        		+ "                            <UnitPrice>\r\n"
        		+ "                                <Money currency=\"USD\">114.82</Money>\r\n"
        		+ "                            </UnitPrice>\r\n"
        		+ "                            <Classification domain=\"\" />\r\n"
        		+ "                            <Extrinsic name=\"LINENUM\">0</Extrinsic>\r\n"
        		+ "                            <Extrinsic name=\"SHIPMENTNUM\">0</Extrinsic>\r\n"
        		+ "                        </ItemDetail>\r\n"
        		+ "                    </ItemOut>\r\n"
        		+ "                    <ItemOut quantity=\"27\" requestedDeliveryDate=\"2024-06-06\" lineNumber=\"102\">\r\n"
        		+ "                        <ItemDetail>\r\n"
        		+ "                            <UnitPrice>\r\n"
        		+ "                                <Money currency=\"USD\">1184.82</Money>\r\n"
        		+ "                            </UnitPrice>\r\n"
        		+ "                            <Classification domain=\"\" />\r\n"
        		+ "                            <Extrinsic name=\"LINENUM\">2</Extrinsic>\r\n"
        		+ "                            <Extrinsic name=\"SHIPMENTNUM\">2</Extrinsic>\r\n"
        		+ "                        </ItemDetail>\r\n"
        		+ "                    </ItemOut>\r\n"
        		+ "                    <ItemOut quantity=\"2\" requestedDeliveryDate=\"2024-08-06\" lineNumber=\"101\">\r\n"
        		+ "                        <ItemID>\r\n"
        		+ "                            <SupplierPartID>3000001986459\\\\1</SupplierPartID>\r\n"
        		+ "                        </ItemID>\r\n"
        		+ "                        <ItemDetail>\r\n"
        		+ "                            <UnitPrice>\r\n"
        		+ "                                <Money currency=\"USD\">1184.82</Money>\r\n"
        		+ "                            </UnitPrice>\r\n"
        		+ "                            <Classification domain=\"\" />\r\n"
        		+ "                            <Extrinsic name=\"LINENUM\">1</Extrinsic>\r\n"
        		+ "                            <Extrinsic name=\"SHIPMENTNUM\">1</Extrinsic>\r\n"
        		+ "                        </ItemDetail>\r\n"
        		+ "                    </ItemOut>\r\n"
        		+ "                    <ItemOut quantity=\"200\" requestedDeliveryDate=\"2024-05-06\" lineNumber=\"103\">\r\n"
        		+ "                        <ItemDetail>\r\n"
        		+ "                            <Classification domain=\"\" />\r\n"
        		+ "                            <Extrinsic name=\"SHIPMENTNUM\">2</Extrinsic>\r\n"
        		+ "                        </ItemDetail>\r\n"
        		+ "                    </ItemOut>\r\n"
        		+ "                </OrderRequest>\r\n"
        		+ "            </Request>";

        String xslt = " <xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\r\n"
        		+ "                <xsl:output method=\"xml\" indent=\"yes\"/>\r\n"
        		+ "                \r\n"
        		+ "                <xsl:template match=\"/Request\">\r\n"
        		+ "                    <OrderDetail>\r\n"
        		+ "                        <xsl:apply-templates select=\"OrderRequest/ItemOut\"/>\r\n"
        		+ "                    </OrderDetail>\r\n"
        		+ "                </xsl:template>\r\n"
        		+ "                \r\n"
        		+ "                <xsl:template match=\"ItemOut\">\r\n"
        		+ "                    <OrderLine requestedDeliveryDate=\"{@requestedDeliveryDate}\" ORDERLINENUMber=\"{@lineNumber}\">\r\n"
        		+ "                        <Quantity>\r\n"
        		+ "                            <xsl:value-of select=\"@quantity\"/>\r\n"
        		+ "                        </Quantity>\r\n"
        		+ "                        <xsl:if test=\"ItemID/SupplierPartID\">\r\n"
        		+ "                            <SupplierPartID>\r\n"
        		+ "                                <xsl:value-of select=\"ItemID/SupplierPartID\"/>\r\n"
        		+ "                            </SupplierPartID>\r\n"
        		+ "                        </xsl:if>\r\n"
        		+ "                        <ItemDetail>\r\n"
        		+ "                            <xsl:apply-templates select=\"ItemDetail/*\"/>\r\n"
        		+ "                            <xsl:apply-templates select=\"ItemDetail/Extrinsic\"/>\r\n"
        		+ "                        </ItemDetail>\r\n"
        		+ "                    </OrderLine>\r\n"
        		+ "                </xsl:template>\r\n"
        		+ "\r\n"
        		+ "                <xsl:template match=\"UnitPrice|Classification|Extrinsic\">\r\n"
        		+ "                    <xsl:copy>\r\n"
        		+ "                        <xsl:apply-templates select=\"@*|node()\"/>\r\n"
        		+ "                    </xsl:copy>\r\n"
        		+ "                </xsl:template>\r\n"
        		+ "                \r\n"
        		+ "            </xsl:stylesheet>";

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
