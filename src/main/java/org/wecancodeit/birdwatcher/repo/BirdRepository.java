package org.wecancodeit.birdwatcher.repo;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.birdwatcher.model.Bird;

public interface BirdRepository extends CrudRepository<Bird, Long> {
}
