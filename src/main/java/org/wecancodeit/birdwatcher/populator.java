package org.wecancodeit.birdwatcher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.birdwatcher.model.Country;
import org.wecancodeit.birdwatcher.repo.CountryRepository;

import javax.annotation.Resource;

@Component
public class populator implements CommandLineRunner {

    @Resource
    private CountryRepository countryStorage;


    @Override
    public void run(String... args) throws Exception {

        Country countryOne = new Country("Thailand", "Central", "Forest");

        Country countryTwo= new Country("Thailand", "Southern", "Tropical");

        Country countryThree= new Country("India", "Northern", "Wetlands");

        Country countryFour= new Country("India", "Southern", "Grasslands");

        countryStorage.save(countryOne);
        countryStorage.save(countryTwo);
        countryStorage.save(countryThree);
        countryStorage.save(countryFour);

    }
}
