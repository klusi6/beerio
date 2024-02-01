package org.vaclavklusacek.beerio.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vaclavklusacek.beerio.model.Beer;

/**
 * BeerRepo is a repository interface for the Beer entity.
 * It extends JpaRepository to provide methods to manipulate Beer entities.
 */
@Repository
public interface BeerRepo extends JpaRepository<Beer, Long> {
}
