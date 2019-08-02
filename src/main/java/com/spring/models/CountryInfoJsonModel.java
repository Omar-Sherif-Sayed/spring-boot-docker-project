package com.spring.models;

import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryInfoJsonModel {
	
	@PrimaryKeyJoinColumn	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("continent")
	private String continent;

	@JsonProperty("population")
	private Integer population;

	@JsonProperty("life_expectancy")
	private Float lifeExpectancy;

	@JsonProperty("country_language")
	private String countryLanguage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Float getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public String getCountryLanguage() {
		return countryLanguage;
	}

	public void setCountryLanguage(String countryLanguage) {
		this.countryLanguage = countryLanguage;
	}
	
	@Override
	public String toString() {
		return "{" 
				+ "\"name\": " + name + ", \n"
				+ "\"continent\": " + continent + ", \n"
				+ "\"population\": " + population + ", \n" 
				+ "\"lifeExpectancy\": " + lifeExpectancy + " \n"
				+ "\"countryLanguage\": \"" + countryLanguage + "\" \n"
				+ '}';
	}

}