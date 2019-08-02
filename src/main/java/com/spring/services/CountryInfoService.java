package com.spring.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.models.CountryInfoJsonModel;
import com.spring.repositories.CountryInfoRepository;

@Service
@Transactional
public class CountryInfoService {

	@Autowired
	private CountryInfoRepository countryInfoRepository;

	public List<CountryInfoJsonModel> getCountryByCountryCode(String countryCode) {
		List<Object[]> resultSetList = countryInfoRepository.getCountryInfoByCountryCode(countryCode);
		
		if (resultSetList == null || resultSetList.isEmpty()) 
			return Collections.emptyList();

		List<CountryInfoJsonModel> countryInfoJsonModelList = new ArrayList<>();

		for (Object[] resultSetArray : resultSetList) {
			CountryInfoJsonModel countryInfoJsonModel = new CountryInfoJsonModel();
			countryInfoJsonModel.setName(String.valueOf(resultSetArray[0] != null ? resultSetArray[0] : ""));
			countryInfoJsonModel.setContinent(String.valueOf(resultSetArray[1] != null ? resultSetArray[1] : ""));
			countryInfoJsonModel.setPopulation(Integer.valueOf(String.valueOf(resultSetArray[2] != null ? resultSetArray[2] : 0)));
			countryInfoJsonModel.setLifeExpectancy(Float.valueOf(String.valueOf(resultSetArray[3] != null ? resultSetArray[3] : 0.0)));
			countryInfoJsonModel.setCountryLanguage(String.valueOf(resultSetArray[4] != null ? resultSetArray[4] : ""));
			countryInfoJsonModelList.add(countryInfoJsonModel);
		}

		return countryInfoJsonModelList;
	}

}
