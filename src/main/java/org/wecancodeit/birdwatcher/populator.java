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

        Country countryTwo = new Country("Thailand", "Southern", "Tropical");

        Country countryThree = new Country("India", "Northern", "Wetlands");

        Country countryFour = new Country("India", "Southern", "Grasslands");

        countryStorage.save(countryOne);
        countryStorage.save(countryTwo);
        countryStorage.save(countryThree);
        countryStorage.save(countryFour);

        Bird crane = new Bird("Siberian Cranes ", "./images/siberian-crane.jpeg",
                "These birds are light grey body and the upper head " +
                        "with red skin. It is the tallest of the flying birds. You will usually see them in the wetlands found " +
                        "in Northwest India. They eat aquatic plants, invertebrates, grains, vertebrates and insects.");
        crane.addCountry(countryThree);

        Bird darter = new Bird("Indian Darter", "./images/indian-darter.jpeg",
                "These birds are long and have a slender neck with a " +
                        "pointed bill. They are found in the wetlands and they like to eat fish.");
        darter.addCountry(countryOne);
        darter.addCountry(countryTwo);
        darter.addCountry(countryThree);
        darter.addCountry(countryFour);

        Bird kingFisher = new Bird("Pied Kingfisher", "./images/pied-kingfisher.jpeg",
                "These fish are black and white plumage. They are found in pairs or small family. They eat fish.");
        kingFisher.addCountry(countryFour);

        Bird pigeon = new Bird("Nilgiri Wood Pigeon", "./images/nigiri-wood-pigeon.jpeg",
                "These bluish grey birds eat wild fruit, berries, seeds, flowers and leaf buds. They usually" +
                        " breed during the season of March to July.");
        pigeon.addCountry(countryFour);

        Bird kite = new Bird("Black-winged Kite", "./images/black-winged-kite.jpeg",
                "These birds are greyish blue. They eat small mammals,bbirds and insects. They are found open" +
                        " area in a grassland habitat. They usually breed during April and May.");
        kite.addCountry(countryOne);
        kite.addCountry(countryTwo);
        kite.addCountry(countryThree);
        kite.addCountry(countryFour);

        Bird parakeet = new Bird("Blue-winged Parakeet", "./images/blue-winged-parakeet.jpeg",
                "These birds have blue tails tipped with yellow and dark wings.These birds are found in small" +
                        " folks. They eat berries, figs, leaf buds, pollen, seeds, nuts, and nectar.");
        parakeet.addCountry(countryFour);

        Bird pitta = new Bird("Malayan Banded Pitta", "./images/malayan-banded-pitta.jpeg",
                "This colourful bird has a black head with a yellow/orange streak above the eye, an orange-red" +
                        " nape, a lemon-yellow throat, a chest barred with orange and dark blue, and a blue belly. The " +
                        "back is brown and the tail is blue.");
        pitta.addCountry(countryTwo);

        Bird hornbill = new Bird("White-crowned Hornbill", "./images/white-crowned-hornbill.jpeg",
                "The female lays two white eggs in a tree hole, then seals herself in by blocking the entrance" +
                        " to the nest with droppings, debris and mud. The female " +
                        "breaks the \"wall\" and leaves the nest when the chicks are able to fly.");
        hornbill.addCountry(countryTwo);

        Bird dove = new Bird("Jambu Fruit Dove", "./images/jambu-fruit-dove.jpeg",
                "The jambu fruit dove is a shy and inconspicuous bird, camouflaged against the forest canopy " +
                        "by its green plumage. It is usually seen alone or in pairs, but a sizable flock may gather when" +
                        " feeding at a fruit tree. ");
        dove.addCountry(countryTwo);

        Bird roller = new Bird("Indochinese Roller", "./images/indochinese-roller.jpeg",
                "The Indochinese roller is distributed across Asia, from eastern India into Southeast Asia.");
        roller.addCountry(countryOne);
        roller.addCountry(countryTwo);
        roller.addCountry(countryThree);
        roller.addCountry(countryFour);

        Bird broadbill = new Bird("Silver-breasted Broadbill", "./images/silver-breasted-broadbill.png",
                "The silver-breasted broadbill eats invertebrates, primarily insects : grasshoppers, mantises," +
                        " caterpillars, larvae, small land snails. These insects are taken by flycatching from perch or " +
                        "by gleaning branches and foliage.");
        broadbill.addCountry(countryOne);
        broadbill.addCountry(countryTwo);
        broadbill.addCountry(countryFour);

        Bird pheasant = new Bird("Silver Pheasant", "./images/silver-pheasant.jpeg",
                "Once considered a very rare species, the imperial pheasant is actually a naturally occurring" +
                        " hybrid between the silver pheasant and the Vietnamese pheasant.");
        pheasant.addCountry(countryOne);


        birdStorage.save(crane);
        birdStorage.save(darter);
        birdStorage.save(kingFisher);

        birdStorage.save(pigeon);
        birdStorage.save(kite);
        birdStorage.save(parakeet);
        birdStorage.save(pitta);
        birdStorage.save(hornbill);
        birdStorage.save(dove);
        birdStorage.save(roller);
        birdStorage.save(broadbill);
        birdStorage.save(pheasant);


    }
}
