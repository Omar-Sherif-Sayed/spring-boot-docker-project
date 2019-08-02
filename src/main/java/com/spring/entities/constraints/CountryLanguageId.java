package com.spring.entities.constraints;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.entities.Country;

@Embeddable
public class CountryLanguageId implements Serializable {

	private static final long serialVersionUID = -6419104932342801943L;

	@ManyToOne
	@JoinColumn(name = "country_code")
	private Country countryCode;

	@Column(name = "language")
	private String language;

	public Country getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Country countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
