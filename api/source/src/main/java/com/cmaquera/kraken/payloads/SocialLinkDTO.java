package com.cmaquera.kraken.payloads;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SocialLinkDTO {

    protected Long id;

    @NotNull(message = "Developer should not be null, blank or empty")
    @Min(1)
    protected Long DeveloperId;
    @NotNull(message = "Social should not be null, blank or empty")
    @Min(1)
    protected Long SocialId;
	
    @NotEmpty
    private String alt;
    @NotEmpty
    private String link;

    private Date createdAt;	
	private Date updatedAt;
    private boolean active;
    
}
