package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.entidades;

import java.util.List;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Decade {

    @XmlAttribute(name = "years")
    private String years;

    @XmlElement(name = "movie")
    private List<Movie> movies;

    public Decade() {}

    public Decade(String years, List<Movie> movies) {
        this.years = years;
        this.movies = movies;
    }
	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "\n Inicio da Exibição de uma Decada." + "\n" + " Years = " + years + "\n"
				+"\n"
				+ " Inicio da exibição de uma serie de Filmes = " + "\n" + " \n" + movies.toString() + "\n" + " \n"
				+"\n"
				+ " Fim da exibição de uma serie de Filmes " + "\n" + " Fim da Exibição de uma Decada." + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(years);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Decade other = (Decade) obj;
		return Objects.equals(years, other.years);
	}

}
