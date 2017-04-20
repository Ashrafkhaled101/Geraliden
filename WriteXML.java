/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dab;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author Abd El Rahman
 */
public class WriteXML {

    String tableName;
    Map<String, String> Columns;

    public WriteXML(String tableName, Map<String, String> Columns) {
        this.tableName = tableName;
        this.Columns = Columns;
    }

    public void createXML() {

        try {
            System.out.println("Writing...");
            StringWriter stringWriter = new StringWriter();

            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);
            xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(new FileWriter(tableName+".xml"));

            xMLStreamWriter.writeStartDocument(); // open file

            xMLStreamWriter.writeStartElement("table");

            xMLStreamWriter.writeStartElement("row");
            //xMLStreamWriter.writeAttribute("company", "Ferrari");

            Iterator<Map.Entry<String, String>> Iterator = Columns.entrySet().iterator();
            while (Iterator.hasNext()) {
                Map.Entry<String, String> Entry = Iterator.next();
                xMLStreamWriter.writeStartElement(Entry.getKey());
                xMLStreamWriter.writeAttribute("dataType", Entry.getValue());
                xMLStreamWriter.writeEndElement();
            }

            xMLStreamWriter.writeEndElement(); // END-ROW

            xMLStreamWriter.writeEndDocument(); // close file

            xMLStreamWriter.flush();
            System.out.println("Closing xMLStreamWriter...");
            stringWriter.close();
            xMLStreamWriter.close();
            xMLStreamWriter = null;
            stringWriter = null;
            System.gc();
            //String xmlString = stringWriter.getBuffer().toString();
            System.out.println("Closing StringWriter...");

            

        } catch (XMLStreamException | IOException e) {
            System.out.println("Error: Table is NOT Created");
        }
    }

}
