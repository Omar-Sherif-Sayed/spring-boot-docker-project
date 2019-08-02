package com.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.entities.constraints.CountryLanguageId;

@Entity(name = "country_language")
public class CountryLanguage implements Serializable {
	
	private static final long serialVersionUID = 1375807986397022390L;

	@EmbeddedId
	private CountryLanguageId countryLanguageId;

	@ManyToOne
	@JoinColumn(name = "country_code", insertable = false, updatable = false)
	private Country countryCode;

	@Column(name = "language", insertable = false, updatable = false)
	private String language;

	@Column(name = "is_official")
	private boolean isOfficial;

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

	public boolean isOfficial() {
		return isOfficial;
	}

	public void setOfficial(boolean isOfficial) {
		this.isOfficial = isOfficial;
	}

}
