package org.wecancodeit.birdwatcher.repo;


import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.birdwatcher.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
