package com.twa.apicatalog.Service;

import com.twa.apicatalog.domain.Country;
import com.twa.apicatalog.dto.CountryDTO;
import com.twa.apicatalog.enums.ApiError;
import com.twa.apicatalog.exception.DuplicateResourceException;
import com.twa.apicatalog.exception.ResourceNotException;
import com.twa.apicatalog.repository.CountryRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    private CountryRepository countryRepository;
    private MapperFacade mapperFacade;

    public CountryDTO get(long id){
        Optional<Country> country = countryRepository.findById(id);
        if(country.isEmpty()){
            throw new ResourceNotException(ApiError.COUNTRY_NOT_FOUND);
        }
        return mapperFacade.map(country.get(),CountryDTO.class);
    }

    public CountryDTO save(CountryDTO countryDTO){
        Optional<Country> existCountry = countryRepository.findByCode(countryDTO.getCode());

        if(existCountry.isPresent()) {
            throw new DuplicateResourceException(ApiError.COUNTRY_WITH_SAME_CODE);
        }

        Country savedCountry = countryRepository.save(mapperFacade.map(countryDTO, Country.class));

        return mapperFacade.map(savedCountry, CountryDTO.class);
    }

    public CountryDTO update(Long id, CountryDTO countryDTO){
        Optional<Country> existCountry = countryRepository.findById(id);

        if(existCountry.isEmpty()) {
            throw new ResourceNotException(ApiError.COUNTRY_NOT_FOUND);
        }

        Country savedCountry = countryRepository.save(mapperFacade.map(countryDTO, Country.class));

        return mapperFacade.map(savedCountry, CountryDTO.class);
    }

    public void delete(long id){
        Optional<Country> existCountry = countryRepository.findById(id);

        if(existCountry.isEmpty()) {
            throw new ResourceNotException(ApiError.COUNTRY_NOT_FOUND);
        }
        countryRepository.deleteById(id);
    }
}
