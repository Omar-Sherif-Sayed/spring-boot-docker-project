package com.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entities.Country;

@Repository
public interface CountryInfoRepository extends JpaRepository<Country, String> {
	
	@Query(value = "SELECT "
			+ "c.name, "
			+ "c.continent, "
			+ "c.population, "
			+ "c.life_expectancy, "
			+ "l.language as country_language "
		+ "FROM "
			+ "country c "
		+ "LEFT JOIN country_language l ON "
			+ "c.code = l.country_code "
		+ "WHERE "
			+ "l.is_official = true "
			+ " AND c.code = ?1 ", nativeQuery = true)
	List<Object[]> getCountryInfoByCountryCode(String countryCode);
	
}
