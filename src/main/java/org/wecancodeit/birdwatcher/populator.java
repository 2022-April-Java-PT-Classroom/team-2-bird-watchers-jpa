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

        Country countryOne = new Country("USA", "North America", "Mountains");
        Country countryTwo= new Country("Canada", "North America", "Deep Forest");

        countryStorage.save(countryOne);
        countryStorage.save(countryTwo);
    }
}
