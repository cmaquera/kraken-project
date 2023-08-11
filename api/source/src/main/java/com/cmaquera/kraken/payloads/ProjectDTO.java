package com.cmaquera.kraken.payloads;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.cmaquera.kraken.models.Technology;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProjectDTO implements Serializable {

    protected Long id;

    @NotNull(message = "Category should not be null, blank or empty")
    @Min(1)
    private Long categoryId;
    @NotNull(message = "Client should not be null, blank or empty")
    @Min(1)
    private Long clientId;
    @NotNull(message = "Developer should not be null, blank or empty")
    @Min(1)
    private Long developerId;
    @NotNull(message = "Image should not be null, blank or empty")
    @Min(1)
    private Long projectImageId;
	
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    private String status;
    @NotEmpty
    private Date starDate;
    private Date endDate;

    private Set<Technology> technologies;

    private Date createdAt;	
	private Date updatedAt;
    private boolean active;
}
