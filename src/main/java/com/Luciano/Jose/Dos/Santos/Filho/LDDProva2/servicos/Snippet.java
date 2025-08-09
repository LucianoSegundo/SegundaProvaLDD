package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.servicos;

import java.io.StringWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class Snippet {
	public void aaa() {
	XMLOutputFactory factory = XMLOutputFactory.newInstance();
	
	StringWriter stringWriter = new StringWriter();
	
	XMLStreamWriter writer;
	try {

		 writer = factory.createXMLStreamWriter(stringWriter);
		 
		 writer.writeStartDocument("UTF-8", "1.0");
		 
	 writer.writeStartElement("html");	 
		 writer.writeStartElement("table");
		 	writer.writeStartElement("thead");
		 		writer.writeStartElement("tr");
		 			writer.writeStartElement("th");
		 				writer.writeCharacters(" Decade ");
		 			writer.writeEndElement();
		 			writer.writeStartElement("th");
		 				writer.writeCharacters(" Quantity ");
		 			writer.writeEndElement();
		 		writer.writeEndElement(); //fecha tr
	 		writer.writeEndElement(); //fecha thead
	 		writer.writeStartElement("tbody");
		
		
		
	 		writer.writeEndElement(); //fecha tbody
		writer.writeEndElement(); //fecha table
	writer.writeEndElement(); //fecha fecha html
	} catch(Exception e) {}
}
}
