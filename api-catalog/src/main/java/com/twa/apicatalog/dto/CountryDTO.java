package com.twa.apicatalog.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CountryDTO {

    private long id;
    @Size(min = 2, max = 3)
    private String code;
    @NotEmpty(message = "this attribute is mandatory")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CountryDTO() {
    }

    public CountryDTO(long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }
}
