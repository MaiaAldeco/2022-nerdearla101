package com.twa.apicatalog.Controller;

import com.twa.apicatalog.Service.CountryService;
import com.twa.apicatalog.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/country")
public class CountryController {

    private CountryService service;

    @Autowired
    public CountryController(CountryService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> get(@PathVariable("id") long id){
        CountryDTO response = service.get(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody @Validated CountryDTO countryDTO){
        CountryDTO response = service.save(countryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> update(@PathVariable("id") long id,@RequestBody @Validated CountryDTO countryDTO){
        CountryDTO response = service.update(id, countryDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        service.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
