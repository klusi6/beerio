package org.vaclavklusacek.beerio.mapper;

import org.vaclavklusacek.beerio.model.Beer;
import org.vaclavklusacek.beerio.dtos.BeerDTO;

/**
 * BeerMapper is a utility class that provides methods to convert between Beer and BeerDTO.
 */
public class BeerMapper {

    /**
     * Converts a BeerDTO to a Beer entity.
     *
     * @param beerDTO The BeerDTO to convert.
     * @return The converted Beer entity.
     */
    public static Beer toBeer(BeerDTO beerDTO){
        return new Beer(beerDTO.id(),beerDTO.uid(), beerDTO.brand(),
                beerDTO.name(),beerDTO.style(),beerDTO.hop(),beerDTO.yeast(),
                beerDTO.malts(),beerDTO.ibu(),beerDTO.alcohol(),beerDTO.blg(),beerDTO.rating());
    }

    /**
     * Converts a Beer entity to a BeerDTO.
     *
     * @param beer The Beer entity to convert.
     * @return The converted BeerDTO.
     */
    public static BeerDTO toBeerDTO(Beer beer){
        return new BeerDTO(beer.getId(),beer.getUid(),beer.getBrand(),
                beer.getName(),beer.getStyle(),beer.getHop(),beer.getYeast(),
                beer.getMalts(),beer.getIbu(),beer.getAlcohol(),beer.getBlg(),beer.getRating());
    }
}