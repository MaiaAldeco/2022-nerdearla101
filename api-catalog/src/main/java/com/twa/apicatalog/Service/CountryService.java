package com.twa.apicatalog.Service;

import com.twa.apicatalog.dto.CountryDTO;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public CountryDTO get(long id){
        return new CountryDTO(1L,"asd","asd");
    }

    public CountryDTO save(CountryDTO countryDTO){
        return  countryDTO;
    }

    public CountryDTO update(Long id, CountryDTO countryDTO){
        return  countryDTO;
    }

    public void delete(long id){
        //TODO agregar logica
    }
}
