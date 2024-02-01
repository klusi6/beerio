package org.vaclavklusacek.beerio.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vaclavklusacek.beerio.mapper.BeerMapper;
import org.vaclavklusacek.beerio.model.Beer;
import org.vaclavklusacek.beerio.dtos.BeerDTO;
import org.vaclavklusacek.beerio.repo.BeerRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
/**
 * Service class for managing beers.
 */
@Service
@AllArgsConstructor
public class BeerService {

    private final RestTemplate restTemplate;
    private final BeerRepo beerRepo;

    /**
     * Loads beers from an external API and saves them in the repository.
     */
    public void loadBeers() {
        Beer[] beers = restTemplate.getForObject("https://random-data-api.com/api/v2/beers?size=100", Beer[].class);
        if (beers != null) {
            beerRepo.saveAll(Arrays.asList(beers));
        }
    }
    /**
     * Finds all beers in the repository.
     * @return a list of all beers.
     */
    public List<Beer> findAll() {
        return beerRepo.findAll();
    }

    /**
     * Deletes a beer by its id.
     * @param id the id of the beer to delete.
     * @return true if the beer was found and deleted, false otherwise.
     */
    public boolean delete(Long id) {
        Optional<Beer> beer = beerRepo.findById(id);

        if (beer.isPresent()) {
            beerRepo.delete(beer.get());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Saves a new beer in the repository.
     * @param beerDTO the beer data transfer object.
     * @return true if the beer was saved successfully, false otherwise.
     */
    public boolean save(BeerDTO beerDTO) {

        try {
            beerRepo.save(BeerMapper.toBeer(beerDTO));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Finds a beer by its id.
     * @param id the id of the beer to find.
     * @return the found beer, or null if no beer was found with the given id.
     */
    public Beer findById(Long id) {
        return beerRepo.findById(id).orElse(null);
    }

    /**
     * Updates the rating of a beer.
     * @param id the id of the beer to update.
     * @param rating the new rating to set.
     * @return true if the beer was found and the rating was updated, false otherwise.
     */
    public boolean update(Long id, String rating) {
        Beer beer = beerRepo.findById(id).orElse(null);
        if (beer != null) {
            beer.setRating(rating);
            beerRepo.save(beer);
            return true;
        }else{
            return false;
        }
    }
}
