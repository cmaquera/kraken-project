package com.cmaquera.kraken.payloads;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TechnologyDTO implements Serializable {
    protected Long id;
	
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;

    private Date createdAt;	
	private Date updatedAt;
    private boolean active;
}
