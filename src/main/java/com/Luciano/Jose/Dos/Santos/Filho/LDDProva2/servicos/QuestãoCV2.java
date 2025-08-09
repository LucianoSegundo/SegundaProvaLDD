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

public class QuestãoCV2 extends DefaultHandler {
	private String arquivo = "";
	String baseUsi = "src/main/resources/";

	public void executar() {
		File aequivo = new File(baseUsi + "movies.xml");
		QuestãoCV2 qquestap = new QuestãoCV2();

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(aequivo, qquestap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Set<Decade> decadas = new LinkedHashSet<Decade>();
	private List<Movie> movies = new ArrayList<Movie>();

	@Override
	public void startDocument() throws SAXException {
		this.arquivo = "<html> \n" + "<table>\n" + "<thead>\n" + "<tr>\n" + "<th> Decade </th>\n"
				+ "<th> Quantity </th>\n" + "</tr>\n" + "</thead>\n" + "<tbody> \n";
	};

	private boolean aaa = false;;

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		if (qName.equals("decade")) {
			Decade decada = new Decade();
			decada.setYears(atts.getValue("years"));
			decadas.add(decada);
		}

		if (qName.equals("year")) {
			this.aaa = true;
		}
	};

	@Override
	public void endDocument() throws SAXException {

		for (Decade decade : decadas) {
			int contador = 0;
			this.arquivo += "<tr>\n" + "<td> " + decade.getYears() + " </td>\n";

			String valor = decade.getYears().replaceFirst("s", "");
			valor = valor.replaceFirst(" ", "");

			int data = Integer.parseInt(valor);

			System.out.println(" Decada = " + data);
			for (Movie movie : movies) {
				int filme = Integer.parseInt(movie.getYear());

				if (filme >= data && filme <= data + 10) {
					System.out.println(" filme = " + filme);
					contador++;
				}
			}
			System.out.println();

			this.arquivo += "<td> " + contador + " </td>\n" + "</tr>\n";

		}

		this.arquivo += "" + "</tbody>\n" + "</table>\n" + "</html>\n";

		new EscreverArquivo().escrever(baseUsi + "respostas/QuestaoCV2.html", arquivo);
		new EscreverArquivo().escrever(baseUsi + "respostas/QuestaoCV2.xml", arquivo);

		System.out.println(arquivo);

		System.out.println("Impresso no arquivo QuestãoC.html e QuestãoC.xml, presente no resource/respontas \n");
		System.out.println("Essa versão ordena com base no número de ano do filme.\n");

	};

	public void characters(char ch[], int start, int length) throws SAXException {
		if (aaa == true) {

			Movie movie = new Movie();

			movie.setYear(new String(ch, start, length));

			movies.add(movie);
			aaa = false;
		}
	};
}
