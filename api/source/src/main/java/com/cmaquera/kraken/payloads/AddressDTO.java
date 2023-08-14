package com.cmaquera.kraken.payloads;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AddressDTO implements Serializable {

    protected Long id;
	
    @NotEmpty
    private String contry;
    @NotEmpty
    private String state;

    private Date createdAt;	
	private Date updatedAt;
    private boolean active;

}
