package org.wecancodeit.birdwatcher.repo;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.birdwatcher.model.Excursion;

public interface ExcursionRepository extends CrudRepository<Excursion, Long> {
}
