package com.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.controllers.CountryInfoController;
import com.spring.models.CountryInfoJsonModel;
import com.spring.repositories.CountryInfoRepository;
import com.spring.services.CountryInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SpringBootDockerApplicationTests {

	@Autowired
	private CountryInfoService countryInfoService;

	@Test
	public void whenValidCountryCodeThenCountryInfoShouldBeFound() {
		String countryCode = "AFG";
		List<CountryInfoJsonModel> countriesResultInfoList = countryInfoService.getCountryByCountryCode(countryCode);

		for (CountryInfoJsonModel countriesResultInfo : countriesResultInfoList) {
			assertNotNull(countriesResultInfo.getName());
			assertNotNull(countriesResultInfo.getContinent());
			assertNotNull(countriesResultInfo.getPopulation());
			assertNotNull(countriesResultInfo.getLifeExpectancy());
			assertNotNull(countriesResultInfo.getCountryLanguage());

			assertEquals(countriesResultInfo.getName(), "Afghanistan");
			assertEquals(countriesResultInfo.getContinent(), "Asia");
			assertEquals(countriesResultInfo.getPopulation(), Integer.valueOf(22720000));
			assertEquals(countriesResultInfo.getLifeExpectancy(), Float.valueOf("45.9"));
		}
	}
	
	@Test
	public void whenNotValidCountryCodeThenCountryInfoShouldNotBeFound() {
		String notValedCountryCode = "NotValedCountryCode";
		List<CountryInfoJsonModel> countriesResultInfoList = countryInfoService.getCountryByCountryCode(notValedCountryCode);
		assertEquals(countriesResultInfoList, Collections.emptyList());
	}

	@Autowired
	private CountryInfoRepository countryInfoRepository;

	@Test
	public void givenCountryCodeThengetResultFromCountryInfoRepository () {
		String countryCode = "ARM";
		List<Object[]> resultListOfArraies = countryInfoRepository.getCountryInfoByCountryCode(countryCode);
		for (Object[] resultOfArraies : resultListOfArraies) {
			assertNotNull(resultOfArraies);
			assertNotNull(resultOfArraies[0]);
			assertNotNull(resultOfArraies[1]);
			assertNotNull(resultOfArraies[2]);
			assertNotNull(resultOfArraies[3]);
			assertNotNull(resultOfArraies[4]);

			assertEquals(resultOfArraies[0], "Armenia");
			assertEquals(resultOfArraies[1], "Asia");
			assertEquals(resultOfArraies[2], Integer.valueOf(3520000));
			assertEquals(resultOfArraies[3], Float.valueOf("66.4"));
			assertEquals(resultOfArraies[4], "Armenian");
		}
	}
	
	@Autowired
	private CountryInfoController countryInfoController;
	
	@Test
	public void testControllerIfCountryCodeIsNotValed() {
		
		String notValedCountryCode = "NotValedCountryCode";
		ResponseEntity<Object> responseEntityResult = countryInfoController.getCountryInfo(notValedCountryCode);
		
		assertEquals(responseEntityResult.getBody().toString(), "INVALID_COUNTRY_CODE");
		assertEquals(responseEntityResult.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@Test
	public void testControllerIfCountryCodeIsValed() {
		
		String countryCode = "ARM";
		ResponseEntity<Object> responseEntityResult = countryInfoController.getCountryInfo(countryCode);
		
		assertEquals(responseEntityResult.getBody().toString(), "[{\"name\": Armenia, \n" + 
				"\"continent\": Asia, \n" + 
				"\"population\": 3520000, \n" + 
				"\"lifeExpectancy\": 66.4 \n" + 
				"\"countryLanguage\": \"Armenian\" \n" + 
				"}]");
		assertEquals(responseEntityResult.getStatusCode(), HttpStatus.ACCEPTED);
		
	}
	
}
