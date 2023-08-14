package com.cmaquera.kraken.payloads;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SocialDTO {

    protected Long id;
	
    @NotEmpty
    private String name;

    private Date createdAt;	
	private Date updatedAt;
    private boolean active;
    
}
