package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.entidades;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "collection")
@XmlAccessorType(XmlAccessType.FIELD)
public class Collection {

    @XmlElement(name = "genre")
    private List<Genre> genre;

    public Collection() {}

    public Collection(List<Genre> genre) {
        this.genre = genre;
    }
	public List<Genre> getGenre() {
		return this.genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return    " \n"
				+ " Inicio da exibição de uma Collection " + "\n" + " Inicio de uma serie de genre = " + "\n" + "\n"
				+ this.genre + "\n" + "\n" + " Fim de uma serie de genre = " + "\n" + "\n"
				+"\n"
				+ " FIm da exibição de uma Collection " + "\n";
	}

}
