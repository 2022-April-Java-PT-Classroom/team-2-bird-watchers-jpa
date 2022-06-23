package org.wecancodeit.birdwatcher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.birdwatcher.model.Bird;
import org.wecancodeit.birdwatcher.model.Country;
import org.wecancodeit.birdwatcher.model.Habitat;
import org.wecancodeit.birdwatcher.model.Region;
import org.wecancodeit.birdwatcher.repo.BirdRepository;
import org.wecancodeit.birdwatcher.repo.CountryRepository;
import org.wecancodeit.birdwatcher.repo.HabitatRepository;
import org.wecancodeit.birdwatcher.repo.RegionRepository;

import javax.annotation.Resource;

@Component
public class populator implements CommandLineRunner {

    @Resource
    private CountryRepository countryStorage;
    @Resource
    private RegionRepository regionStorage;
    @Resource
    private HabitatRepository habitatStorage;

    @Resource
    private BirdRepository birdStorage;


    @Override
    public void run(String... args) throws Exception {

//---Country------------------------------------
        Country country1 = new Country("Thailand", "", "");
        countryStorage.save(country1);
        Country country2= new Country("Singapore", "", "");
        countryStorage.save(country2);
        Country country3= new Country("India", "", "");
        countryStorage.save(country3);
        Country country33= new Country("China", "", "");
        countryStorage.save(country33);
        Country country333= new Country("Japan", "", "");
        countryStorage.save(country333);
        Country country3333= new Country("Mongolia", "", "");
        countryStorage.save(country3333);
        Country country4= new Country("Sri Lanka", "", "");
        countryStorage.save(country4);
        Country country5= new Country("USA", "", "");
        countryStorage.save(country5);
        Country country6= new Country("Canada", "", "");
        countryStorage.save(country6);
        Country country7= new Country("Brazil", "", "");
        countryStorage.save(country7);
        Country country8= new Country("Mexico", "", "");
        countryStorage.save(country8);
        Country country9= new Country("Spain", "", "");
        countryStorage.save(country9);
        Country country10= new Country("Egypt", "", "");
        countryStorage.save(country10);

//---Habitat------------------------------------

        Habitat habitat1 = new Habitat("Forest");
        habitatStorage.save(habitat1);
        Habitat habitat2 = new Habitat("Tropical");
        habitatStorage.save(habitat2);
        Habitat habitat3 = new Habitat("Wetlands");
        habitatStorage.save(habitat3);
        Habitat habitat4 = new Habitat("Grasslands");
        habitatStorage.save(habitat4);
        Habitat habitat5 = new Habitat("Mountains");
        habitatStorage.save(habitat5);


//---Region------------------------------------
        Region region1 = new Region("Central Asia");
        region1.addCountry(country2);
        regionStorage.save(region1);

        Region region2 = new Region("North Asia");
        region2.addCountry(country3);
        region2.addCountry(country33);
        region2.addCountry(country333);
        region2.addCountry(country3333);
        regionStorage.save(region2);

        Region region3 = new Region("South Asia");
        region3.addCountry(country2);
        region3.addCountry(country3);
        region3.addCountry(country33);
        region3.addCountry(country4);
        regionStorage.save(region3);

        Region region4 = new Region("Central America");
        region4.addCountry(country8);
        regionStorage.save(region4);

        Region region5 = new Region("North America");
        region5.addCountry(country8);
        region5.addCountry(country5);
        region5.addCountry(country6);
        regionStorage.save(region5);

        Region region6 = new Region("South America");
        region6.addCountry(country7);
        regionStorage.save(region6);

        Region region7 = new Region("West Europe");
        region7.addCountry(country9);
        regionStorage.save(region7);

        Region region8 = new Region("North Africa");
        region8.addCountry(country10);
        regionStorage.save(region8);

        Region region9 = new Region("South Australia");
        regionStorage.save(region9);

//---Bird------------------------------------

        Bird crane = new Bird("Siberian Cranes ", "https://upload.wikimedia.org/wikipedia/commons/0/0f/Double_Trouble_%284919788838%29.jpg",
                "These birds are light grey body and the upper head with red skin. It is the tallest of the flying birds. You will usually see them in the wetlands found in Northwest India. They eat aquatic plants, inverebrates, grains, vertrbrates and insects.");

        crane.addHabitat(habitat1);
        crane.addHabitat(habitat2);

        crane.addCountry(country1);
        crane.addCountry(country3);
        crane.addCountry(country4);

        birdStorage.save(crane);

        Bird darter = new Bird("Indian Darter", "https://th.bing.com/th/id/OIP.m7ltN_Hbca4KkS_gE6gjSgHaLH?pid=ImgDet&rs=1",
                "These birds are long and have a slender neck with a pointed bill. They are found in the wetlands and they like to eat fish.");

        darter.addHabitat(habitat1);
        darter.addHabitat(habitat3);
        darter.addHabitat(habitat5);

        darter.addCountry(country2);
        darter.addCountry(country4);

        birdStorage.save(darter);


        Bird kingFisher = new Bird("Pied Kingfisher","picture",
                "These fish are black and white plumage. They are found in pairs or small family. They eat fish.");

        kingFisher.addCountry(country7);
        kingFisher.addCountry(country9);
        kingFisher.addCountry(country10);
        birdStorage.save(kingFisher);

        Bird pigeons = new Bird("Nilgiri Wood Pigeons", "picture",
                "These bluish grey birds eat wild fruit, berries, seeds, flowers and leaf buds. They usually breed during the season of March to July.");
        birdStorage.save(pigeons);

        Bird kite = new Bird("Black-winged Kite", "picture",
                "These birds are greyish blue. They eat small mammals, birds and insects. They are found open area in a grassland habitat. They usually brred during April and May.");

        kite.addCountry(country7);
        kite.addCountry(country3);
        kite.addCountry(country3333);
        kite.addCountry(country10);
        kite.addCountry(country9);
        birdStorage.save(kite);

        Bird parakeets = new Bird("Blue-winged Parakeets", "picture",
                "These birds have blue tails tipped with yellow and dark wings.These birds are found in small folks. They eat berries, figs, leaf buds, pollen, seeds, nuts, and nectar.");

        parakeets.addCountry(country9);
        parakeets.addCountry(country4);
        parakeets.addCountry(country5);
        parakeets.addCountry(country6);

        parakeets.addHabitat(habitat3);
        parakeets.addHabitat(habitat4);

        parakeets.addRegion(region3);
        parakeets.addRegion(region1);

        birdStorage.save(parakeets);

    }
}
