package org.wecancodeit.birdwatcher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.birdwatcher.model.Bird;
import org.wecancodeit.birdwatcher.model.Country;
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

        Country countryOne = new Country("Thailand", "Central", "Forest");

        Country countryTwo= new Country("Thailand", "Southern", "Tropical");

        Country countryThree= new Country("India", "Northern", "Wetlands");

        Country countryFour= new Country("India", "Southern", "Grasslands");

        countryStorage.save(countryOne);
        countryStorage.save(countryTwo);
        countryStorage.save(countryThree);
        countryStorage.save(countryFour);

        Bird crane = new Bird("Siberian Cranes ", "picture", "These birds are light grey body and the upper head with red skin. It is the tallest of the flying birds. You will usually see them in the wetlands found in Northwest India. They eat aquatic plants, inverebrates, grains, vertrbrates and insects.");
        Bird darter = new Bird("Indian Darter", "picture", "These birds are long and have a slender neck with a pointed bill. They are found in the wetlands and they like to eat fish.");
        Bird kingFisher = new Bird("Pied Kingfisher","picture", "These fish are black and white plumage. They are found in pairs or small family. They eat fish.");
        Bird pigeons = new Bird("Nilgiri Wood Pigeons", "picture", "These bluish grey birds eat wild fruit, berries, seeds, flowers and leaf buds. They usually breed during the season of March to July.");
        Bird kite = new Bird("Black-winged Kite", "picture", "These birds are greyish blue. They eat small mammals, birds and insects. They are found open area in a grassland habitat. They usually brred during April and May.");
        Bird parakeets = new Bird("Blue-winged Parakeets", "picture", "These birds have blue tails tipped with yellow and dark wings.These birds are found in small folks. They eat berries, figs, leaf buds, pollen, seeds, nuts, and nectar.");

        birdStorage.save(crane);
        birdStorage.save(darter);
        birdStorage.save(kingFisher);
        birdStorage.save(pigeons);
        birdStorage.save(kite);
        birdStorage.save(parakeets);



    }
}
