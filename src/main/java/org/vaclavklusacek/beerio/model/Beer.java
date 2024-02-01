package org.vaclavklusacek.beerio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

/**
 * Beer is an entity class that represents a beer in the database.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String uid;
    @NotBlank
    private String brand;
    @NotBlank
    private String name;
    @NotBlank
    private String style;
    @NotBlank
    private String hop;
    @NotBlank
    private String yeast;
    @NotBlank
    private String malts;
    @NotBlank
    private String ibu;
    @NotBlank
    private String alcohol;
    @NotBlank
    private String blg;
    private String rating;
}
