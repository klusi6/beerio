package org.vaclavklusacek.beerio.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vaclavklusacek.beerio.dtos.BeerDTO;
import org.vaclavklusacek.beerio.dtos.MessageDTO;
import org.vaclavklusacek.beerio.mapper.BeerMapper;
import org.vaclavklusacek.beerio.model.Beer;
import org.vaclavklusacek.beerio.service.BeerService;

import java.util.stream.Collectors;

/**
 * ApiController class that handles all the API requests.
 */
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {

    private final BeerService beerService;

    /**
     * Index endpoint that returns a welcome message.
     *
     * @return ResponseEntity with a welcome message.
     */
    @GetMapping("")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(new MessageDTO("Beers has been loaded", "200"));
    }

    /**
     * Endpoint to delete a beer by its ID.
     *
     * @param id The ID of the beer to delete.
     * @return ResponseEntity with no content if the deletion was successful, not found otherwise.
     */
    @DeleteMapping("/beers/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return beerService.delete(id) ?
                ResponseEntity.status(204).body(new MessageDTO("Beer has been deleted", "204")) :
                ResponseEntity.status(404).body(new MessageDTO("Beer has not been found", "404"));
    }

    /**
     * Endpoint to get all beers.
     *
     * @return ResponseEntity with a list of all beers.
     */
    @GetMapping("/beers")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(beerService.findAll()
                .stream()
                .map(BeerMapper::toBeerDTO)
                .collect(Collectors.toList()));
    }

    /**
     * Endpoint to save a new beer.
     *
     * @param beerDTO The beer to save.
     * @return ResponseEntity with a message if the beer was saved successfully, bad request otherwise.
     */
    @PostMapping("/beers")
    public ResponseEntity<?> save(@RequestBody BeerDTO beerDTO) {
        return beerService.save(beerDTO) ?
                ResponseEntity.status(201).body(new MessageDTO("Beer has been saved", "201")) :
                ResponseEntity.status(400).body(new MessageDTO("Beer has not been saved", "400"));
    }

    /**
     * Endpoint to find a beer by its ID.
     *
     * @param id The ID of the beer to find.
     * @return ResponseEntity with the beer if found, not found otherwise.
     */
    @GetMapping("/beers/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Beer beer = beerService.findById(id);
        return beer != null ?
                ResponseEntity.status(201).body(new BeerDTO(beer)) :
                ResponseEntity.status(404).body(new MessageDTO("Beer has not been found", "404"));
    }

    /**
     * Endpoint to update a beer's rating by its ID.
     *
     * @param id     The ID of the beer to update.
     * @param rating The new rating for the beer.
     * @return ResponseEntity with a message if the beer was updated successfully, not found otherwise.
     */
    @PutMapping("/beers/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestParam String rating) {
        return beerService.update(id, rating) ?
                ResponseEntity.status(200).body(new MessageDTO("Beer has been updated", "200")) :
                ResponseEntity.status(404).body(new MessageDTO("Beer has not been found", "404"));
    }
}