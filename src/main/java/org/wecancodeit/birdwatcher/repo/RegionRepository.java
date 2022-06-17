package org.wecancodeit.birdwatcher.repo;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.birdwatcher.model.Region;

public interface RegionRepository extends CrudRepository<Region, Long> {

}

