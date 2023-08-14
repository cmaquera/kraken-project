package com.cmaquera.kraken.payloads;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeveloperDTO {
    
    protected Long id;

    @NotNull(message = "Access should not be null, blank or empty")
    @Min(1)
    private Long credentialId;
    @NotNull(message = "Adress should not be null, blank or empty")
    @Min(1)
    private Long addressId;
    @NotNull(message = "Image should not be null, blank or empty")
    @Min(1)
    private Long imageId;
	
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastname;
    private String description;
    private String nikname;
    @NotEmpty
    private String shortDescription;
    private String title;

    private Date createdAt;	
	private Date updatedAt;
    private boolean active;

}
