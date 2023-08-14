package com.cmaquera.kraken.payloads;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ImageDTO {

    protected Long id;
	
    @NotEmpty
    private String url;
    @NotEmpty
    private String description;

    private Date createdAt;	
	private Date updatedAt;
    private boolean active;

}
