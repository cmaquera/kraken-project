package com.cmaquera.kraken.payloads;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CredentialDTO {

    protected Long id;

    @NotEmpty
    private String username;
	
    @NotEmpty
    private String password;    

    private Date createdAt;	
	private Date updatedAt;
    private boolean active;


}
