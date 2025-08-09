package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.servicos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscreverArquivo {
	  public static void escrever(String caminho, String conteudo) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, false))) {
	            writer.write(conteudo);
	            System.out.println("Arquivo criado/sobrescrito com sucesso: " + caminho);
	        } catch (IOException e) {
	            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
	        }
	    }
}
