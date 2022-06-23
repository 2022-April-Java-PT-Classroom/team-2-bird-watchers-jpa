package org.wecancodeit.birdwatcher.repo;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.birdwatcher.model.Habitat;

public interface HabitatRepository extends CrudRepository<Habitat, Long> {
}
