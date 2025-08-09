package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.servicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.entidades.Decade;
import com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.entidades.Movie;

public class QuestãoC extends DefaultHandler {
	
	String baseUsi = "src/main/resources/";
	
	private Set<Decade> decadas = new LinkedHashSet<Decade>();
	private Decade temporaria;
	private boolean filmeBolean = false;
	
	XMLOutputFactory factory = XMLOutputFactory.newInstance();

    XMLStreamWriter writer ;

	
	public void executar() {
		File aequivo = new File(baseUsi + "movies.xml");
		QuestãoC qquestap = new QuestãoC();

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(aequivo, qquestap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void startDocument() throws SAXException {
		
        try {
        	writer = factory.createXMLStreamWriter(new FileOutputStream(baseUsi+"respostas/QuestaoC.xml"), "UTF-8");

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
			 
		} 
        catch (XMLStreamException e) {
        	
			e.printStackTrace();
			
			}
        catch (FileNotFoundException e) {
        	
			e.printStackTrace();
			
		}

	};

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		if (qName.equals("decade")) {
			Decade decada = new Decade();
			decada.setMovies(new ArrayList<Movie>());
			decada.setYears(atts.getValue("years"));

			this.temporaria = decada;
			System.out.println("decada "+atts.getValue("years"));
		}

		if (qName.equals("year")) {
			this.filmeBolean = true;
		}
	};

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	    if (qName.equals("decade")) {
	        if (!decadas.add(temporaria)) {
	            for (Decade decade : decadas) {
	                if (decade.getYears().equals(temporaria.getYears())) {
	                    decade.getMovies().addAll(temporaria.getMovies());
	                }
	            }
	        }
	    }
	};
 
	@Override
	public void endDocument() throws SAXException {
		try {
		for (Decade decade : decadas) {
	        int contador = 0;
	        
	        writer.writeStartElement("tr");
	        	writer.writeStartElement("td");
	        		writer.writeCharacters(" " + decade.getYears() + " ");
	      
	        	writer.writeEndElement(); // fechando td
	        	
	        String valor = decade.getYears().replaceFirst("s", "").trim();
	        	   valor = valor.replaceFirst(" ", "").trim();
	        
	        int ano = Integer.parseInt(valor);

	        System.out.println("Ano = " + ano);

	        for (Movie movie : decade.getMovies()) {
	            int filme = Integer.parseInt(movie.getYear());
	            System.out.println("filme = " + filme);
	            contador++;
	        }
	        writer.writeStartElement("td");
    			writer.writeCharacters(" " + contador  + " ");
    		writer.writeEndElement(); // fechando td

    		writer.writeEndElement(); // fechando tr

	    }

 		writer.writeEndElement(); //fecha tbody
 		writer.writeEndElement(); //fecha table
	
			writer.writeEndElement();//fecha fecha html
			
			 writer.flush();
	            writer.close();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	    System.out.println("Impresso no arquivo QuestaoC.xml, presente em resource/respostas\n");

	  	}

	
	public void characters(char ch[], int start, int length) throws SAXException {
		if (filmeBolean == true) {

			Movie movie = new Movie();

			movie.setYear(new String(ch, start, length));

			System.out.println("filme " + new String(ch, start, length));
			temporaria.getMovies().add(movie);
			filmeBolean = false;
		}
	};
}
