package org.wecancodeit.birdwatcher.repo;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.birdwatcher.model.Travel;

public interface TravelRepository extends CrudRepository<Travel, Long> {
}
