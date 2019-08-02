package com.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.models.CountryInfoJsonModel;
import com.spring.services.CountryInfoService;

@RestController
public class CountryInfoController {

	@Autowired
	private CountryInfoService countryInfoService;

	@GetMapping("/{countryCode}")
	@ResponseBody
	public ResponseEntity<Object> getCountryInfo(@PathVariable(required = true) String countryCode) {

		List<CountryInfoJsonModel> countriesResultInfo = null;
		try {
			countriesResultInfo = countryInfoService.getCountryByCountryCode(countryCode);
		} catch (Exception e) {
			return new ResponseEntity<>("INTERNAL_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (countriesResultInfo == null || countriesResultInfo.isEmpty()) {
			return new ResponseEntity<>("INVALID_COUNTRY_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(countriesResultInfo, HttpStatus.ACCEPTED);
	}

}
