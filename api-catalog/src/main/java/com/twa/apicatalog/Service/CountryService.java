package com.twa.apicatalog.Service;

import com.twa.apicatalog.dto.CountryDTO;
import com.twa.apicatalog.enums.ApiError;
import com.twa.apicatalog.exception.ResourceNotException;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public CountryDTO get(long id){
        if(id != 1){
            throw new ResourceNotException(ApiError.COUNTRY_NOT_FOUND);
        }
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
