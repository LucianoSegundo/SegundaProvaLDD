package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.servicos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class QuestãoD {

	String baseUsi="src/main/resources/";
String arquivo = "";
	
	public void executar() throws FileNotFoundException, XMLStreamException {
		XMLInputFactory xif = XMLInputFactory.newFactory();
		XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader(baseUsi+"movies.xml"));
		
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
				arquivo = "<html>\n"
						+ "<table >\n"
						+ "<thead >\n"
						+ "<tr>\n"
						+ "<th> Rating </th>\n"
						+ "<th> Quantity </th>\n"
						+ "</tr>\n"
						+ "</thead>\n"
						+ "<tbody>\n";
				
				
				for (temporario temporario : temporarioz) {
					arquivo += "<tr>\n"
							+ "<td>" +temporario.tipo+ "</td>\n"
							+ "<td>"+ temporario.quantidade+"</td>\n"
							+ "</tr>\n";
				}
				
				arquivo+= "</tbody>\n"
						+ "</table>\n"
						+ "</html>\n";
				
				break;
			}
			}
			xsr.close();
			
				System.out.println(arquivo);
				System.out.println();
			    System.out.println("Impresso no arquivo QuestaoD.html e QuestaoD.xml, presente em resource/respostas\n");

			    new EscreverArquivo().escrever(baseUsi + "respostas/QuestaoD.html", arquivo);
			    new EscreverArquivo().escrever(baseUsi + "respostas/QuestaoD.xml", arquivo);
		
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
