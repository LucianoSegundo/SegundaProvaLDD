package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.servicos;

import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class QuestãoB {

public void executar() {
	try {
		
		String baseUsi="src/main/resources/";

		TransformerFactory factory = TransformerFactory.newInstance();
		
		Source xslt = new StreamSource(new File(baseUsi+"questaob.xslt"));
		Source text = new StreamSource(new File(baseUsi+"movies.xml"));

		
		Transformer transformer = factory.newTransformer(xslt);
		transformer.transform(text, new StreamResult(new File(baseUsi+"respostas/QuestaiB.html")));
		transformer.transform(text, new StreamResult(new File(baseUsi+"respostas/QuestaiB.xml")));
		System.out.println("Impresso no arquivo QuestãoB.html e QuestãoB.xml, presente no resource/respontas \n");

		
	} catch (Exception e) {
e.printStackTrace();
}
	}
}
