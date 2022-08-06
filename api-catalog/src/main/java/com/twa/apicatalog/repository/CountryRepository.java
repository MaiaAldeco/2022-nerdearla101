package com.twa.apicatalog.repository;

import com.twa.apicatalog.domain.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

     Optional<Country> findByCode(String code);
}
