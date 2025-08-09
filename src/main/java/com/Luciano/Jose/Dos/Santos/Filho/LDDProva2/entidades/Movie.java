package com.Luciano.Jose.Dos.Santos.Filho.LDDProva2.entidades;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {

    @XmlAttribute(name = "title")
    private String title;

    @XmlAttribute(name = "favorite")
    private Boolean favorite;

    @XmlElement(name = "format")
    private String format; 
    
    @XmlElement(name = "year")
    private String year;

    @XmlElement(name = "rating")
    private String rating;

    @XmlElement(name = "description")
    private String description;

    public Movie() {} 

    public Movie(String title, Boolean favorite, String format, String year, String rating, String description) {
        this.title = title;
        this.favorite = favorite;
        this.format = format;
        this.year = year;
        this.rating = rating;
        this.description = description;
    };
        
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "\nInicio de um Filme "+ "\n"
				+"\n"
				+ " title = " + title + "\n"
				+ " favorite = " + favorite + "\n"
				+ " format = " + format + "\n"
				+ " year = " + year + "\n"
				+ " rating = " + rating + "\n"
				+ " description = " + description +"\n"
				+"\n"
				+ " Inicio de um Filme "+ "\n";
		
	}
	
	
	
	
}
