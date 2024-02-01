package org.vaclavklusacek.beerio.dtos;

import org.vaclavklusacek.beerio.model.Beer;

/**
 * BeerDTO is a Data Transfer Object for the Beer entity.
 * It is used to transfer data between processes or components.
 */

public record BeerDTO(Long id, String uid, String brand, String name, String style, String hop, String yeast,
                      String malts, String ibu, String alcohol, String blg, String rating) {

    /**
     * Constructor for creating a new BeerDTO from a Beer entity.
     *
     * @param beer The Beer entity to create the DTO from.
     */
    public BeerDTO(Beer beer) {
        this(beer.getId(), beer.getUid(), beer.getBrand(), beer.getName(), beer.getStyle(), beer.getHop(),
                beer.getYeast(), beer.getMalts(), beer.getIbu(), beer.getAlcohol(), beer.getBlg(), beer.getRating());
    }

}