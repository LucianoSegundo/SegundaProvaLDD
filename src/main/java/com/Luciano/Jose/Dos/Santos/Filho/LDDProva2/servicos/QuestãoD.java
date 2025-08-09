package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.servicos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class QuestãoD {

	String baseUsi="src/main/resources/";
String arquivo = "";
	
	public void executar() throws FileNotFoundException, XMLStreamException {
		
		XMLInputFactory xif = XMLInputFactory.newFactory();
		XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader(baseUsi+"movies.xml"));
		
		
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		
		StringWriter stringWriter = new StringWriter();
		
		XMLStreamWriter writer;
		try {
			 writer = factory.createXMLStreamWriter(stringWriter);
			 
			 writer.writeStartDocument("UTF-8", "1.0");
		
		Set<temporario> temporarioz = new HashSet<>();
		Boolean temp = false;
		temporario t = new temporario();
		String qName ="";
		
		while(xsr.hasNext()) {
			switch(xsr.next()) {
			case XMLStreamReader.START_DOCUMENT:
				
				break;
				
			case XMLStreamReader.START_ELEMENT:
				
			 qName = xsr.getLocalName();

			if(qName.equals("rating")) {
				temp = true;
			}
			
			break;
			case XMLStreamReader.CHARACTERS:
				
				if(temp == true) {
					t.tipo =  xsr.getText().trim();
					t.quantidade = 1;
					temp = false;
				}
		
				break;
			case XMLStreamReader.END_ELEMENT:

				if(qName.equals("rating")) {
				
				if(temporarioz.add(t) ==false) {
					for (temporario temporario : temporarioz) {
						if(temporario.tipo.equals(t.tipo)) temporario.quantidade++;
					}
				}
				t = new temporario();
				
				temp = false;
				qName = "";
				}
				break;
			case XMLStreamReader.END_DOCUMENT:
				
				writer.writeStartElement("html");	 
				 writer.writeStartElement("table");
				 	writer.writeStartElement("thead");
				 		writer.writeStartElement("tr");
				 			writer.writeStartElement("th");
				 				writer.writeCharacters(" Rating ");
				 			writer.writeEndElement();
				 			writer.writeStartElement("th");
				 				writer.writeCharacters(" Quantity ");
				 			writer.writeEndElement();
				 		writer.writeEndElement(); //fecha tr
			 		writer.writeEndElement(); //fecha thead
			 		writer.writeStartElement("tbody");
				
				for (temporario temporario : temporarioz) {
					
					writer.writeStartElement("tr");
					writer.writeStartElement("td");
					writer.writeCharacters(temporario.tipo);
					writer.writeEndElement();
					
					writer.writeStartElement("td");
					writer.writeCharacters(""+temporario.quantidade);
					writer.writeEndElement();
					
					writer.writeEndElement();
				}
				
				writer.writeEndElement(); //fecha tbody
				writer.writeEndElement(); //fecha table
			writer.writeEndElement(); //fecha fecha html
				break;
			}
			}
			xsr.close();
			
			
		} catch(Exception e) {
			
		}
		
				System.out.println(stringWriter.toString());
				System.out.println();
			    System.out.println("Impresso no arquivo QuestaoD.html e QuestaoD.xml, presente em resource/respostas\n");

			    new EscreverArquivo().escrever(baseUsi + "respostas/QuestaoD.html", stringWriter.toString());
			    new EscreverArquivo().escrever(baseUsi + "respostas/QuestaoD.xml", stringWriter.toString());
		
	}
	
	
}

 class temporario {
	String tipo;
	int quantidade;
	@Override
	public int hashCode() {
		return Objects.hash(tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		temporario other = (temporario) obj;
		return Objects.equals(tipo, other.tipo);
	}
	
	
}
