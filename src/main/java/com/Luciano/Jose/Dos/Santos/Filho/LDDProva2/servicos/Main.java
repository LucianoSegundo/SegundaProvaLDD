package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.servicos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Main implements CommandLineRunner{

	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Execução da questão A");
		System.out.println();
		
		new QuestãoA().executar();
		
		System.out.println();
		System.out.println("Execução da questão B Utilizando DOM");
		System.out.println();
		
		new QuestãoB().executar();

		
		System.out.println();
		System.out.println("Execução da questão C Utilizando SAX");
		System.out.println();
		
		new QuestãoC().executar();

		
		System.out.println();
		System.out.println("Execução da questão CV2 Utilizando SAX");
		System.out.println();
		
		new QuestãoCV2().executar();

		
		System.out.println();
		System.out.println("Execução da questão D Utilizando StaX");
		System.out.println();

		new QuestãoD().executar();

	}



}
