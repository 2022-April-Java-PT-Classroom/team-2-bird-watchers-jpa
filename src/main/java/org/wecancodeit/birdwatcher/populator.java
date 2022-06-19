package org.wecancodeit.birdwatcher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.birdwatcher.model.Country;
import org.wecancodeit.birdwatcher.model.Region;
import org.wecancodeit.birdwatcher.repo.BirdRepository;
import org.wecancodeit.birdwatcher.repo.CountryRepository;
import org.wecancodeit.birdwatcher.repo.RegionRepository;

import javax.annotation.Resource;

@Component
public class populator implements CommandLineRunner {

    @Resource
    private CountryRepository countryStorage;
    @Resource
    private RegionRepository regionStorage;
    @Resource
    private BirdRepository birdStorage;


    @Override
    public void run(String... args) throws Exception {

//        Region regionOne = new Region("Central", "Forest");
//        Region regionTwo = new Region("Southern", "Tropical");
//        Region regionThree = new Region("Northern", "Wetlands");
//        Region regionFour = new Region("Southern", "Grasslands");
//
//        regionStorage.save(regionOne);
//        regionStorage.save(regionTwo);
//        regionStorage.save(regionThree);
//        regionStorage.save(regionFour);

        Country countryOne = new Country("Thailand", "Central", "Forest");

        Country countryTwo= new Country("Thailand", "Southern", "Tropical");

        Country countryThree= new Country("India", "Northern", "Wetlands");

        Country countryFour= new Country("India", "Southern", "Grasslands");

        countryStorage.save(countryOne);
        countryStorage.save(countryTwo);
        countryStorage.save(countryThree);
        countryStorage.save(countryFour);



//        birdStorage.save(birdOne);

    }
}
