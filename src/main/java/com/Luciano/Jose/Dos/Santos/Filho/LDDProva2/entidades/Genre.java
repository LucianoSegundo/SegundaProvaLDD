package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.entidades;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Genre {

    @XmlAttribute(name = "category")
    private String category;

    @XmlElement(name = "decade")
    private List<Decade> decade;

    public Genre() {} 

    public Genre(String category, List<Decade> decade) {
        this.category = category;
        this.decade = decade;
    }
    
	public String getCategory() {
		return category;
	}

	public void setCategory(String years) {
		category = years;
	}

	public List<Decade> getDecade() {
		return decade;
	}

	public void setDecade(List<Decade> decade) {
		this.decade = decade;
	}

	@Override
	public String toString() {
		return "\n Inicio da Exibição de um Gênero." + "\n" + " Years = " + category + "\n"
				+ " Inicio da exibição de uma serie de Decadas = " + "\n" + " \n" + decade.toString() + "\n" + " \n"
				+ " Fim da exibição de uma serie de Decadas " 
				+ "\n" 
				+ " Fim da Exibição de uma Gênero." + "\n";
	}

}
