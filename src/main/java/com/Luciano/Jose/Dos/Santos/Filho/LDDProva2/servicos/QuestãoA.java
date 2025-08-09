package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.servicos;

import javax.xml.transform.stream.StreamSource;

import com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.entidades.Collection;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;


public class QuestãoA {

public void executar() throws JAXBException {
try {
	
	String baseUsi="./src/main/resources/";
	JAXBContext context = JAXBContext.newInstance(Collection.class);
	Unmarshaller um = context.createUnmarshaller();
	Collection colecao = (Collection) um.unmarshal(new StreamSource(baseUsi+"movies.xml"));
	
	System.out.println("Impresso no arquivo QuestãoA.txt, presente no resource\respontas \n");
	System.out.println(colecao.toString());
	
	EscreverArquivo.escrever(baseUsi+"respostas/QuestaoA.txt", colecao.toString());
	
} catch (jakarta.xml.bind.JAXBException e) {
    if (e.getCause() instanceof org.glassfish.jaxb.runtime.v2.runtime.IllegalAnnotationsException iae) {
        iae.getErrors().forEach(System.out::println);
    } else {
        e.printStackTrace();
    }
	
	}
}
}
