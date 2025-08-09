package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.servicos;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.entidades.Decade;
import com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.entidades.Movie;

public class QuestãoC extends DefaultHandler {
	private String arquivo = "";
	String baseUsi = "src/main/resources/";
	private Set<Decade> decadas = new LinkedHashSet<Decade>();
	private List<Movie> movies = new ArrayList<Movie>();
	private Decade temporaria;
	private boolean filmeBolean = false;
	private boolean DecadaBolean = false;

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
		this.arquivo = "<html> \n" + "<table>\n" + "<thead>\n" + "<tr>\n" + "<th> Decade </th>\n"
				+ "<th> Quantity </th>\n" + "</tr>\n" + "</thead>\n" + "<tbody> \n";
	};

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		if (qName.equals("decade")) {
			Decade decada = new Decade();
			decada.setMovies(new ArrayList<Movie>());
			decada.setYears(atts.getValue("years"));

			this.temporaria = decada;
			System.out.println("decada "+atts.getValue("years"));
			this.DecadaBolean = true;
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
	        DecadaBolean = false;
	    }
	};
 
	@Override
	public void endDocument() throws SAXException {

		for (Decade decade : decadas) {
	        int contador = 0;

	        this.arquivo += "<tr>\n";
	        this.arquivo += "<td> " + decade.getYears() + " </td>\n";

	        String valor = decade.getYears().replaceFirst("s", "").trim();
	        int data = Integer.parseInt(valor);

	        System.out.println("data = " + data);

	        for (Movie movie : decade.getMovies()) {
	            int filme = Integer.parseInt(movie.getYear());
	            System.out.println("filme = " + filme);
	            contador++;
	        }

	        this.arquivo += "<td> " + contador + " </td>\n";
	        this.arquivo += "</tr>\n";
	    }

	    this.arquivo += "</tbody>\n</table>\n</html>\n";

	    System.out.println(arquivo);
	    System.out.println("Impresso no arquivo QuestaoC.html e QuestaoC.xml, presente em resource/respostas\n");

	    new EscreverArquivo().escrever(baseUsi + "respostas/QuestaoC.html", arquivo);
	    new EscreverArquivo().escrever(baseUsi + "respostas/QuestaoC.xml", arquivo);
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
