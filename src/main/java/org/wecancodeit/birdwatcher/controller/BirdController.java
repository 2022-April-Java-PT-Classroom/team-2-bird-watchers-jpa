package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.wecancodeit.birdwatcher.model.Bird;
import org.wecancodeit.birdwatcher.model.Bird;
import org.wecancodeit.birdwatcher.model.Country;
import org.wecancodeit.birdwatcher.model.Habitat;
import org.wecancodeit.birdwatcher.model.Region;
import org.wecancodeit.birdwatcher.repo.BirdRepository;

import org.wecancodeit.birdwatcher.repo.CountryRepository;
import org.wecancodeit.birdwatcher.repo.HabitatRepository;
import org.wecancodeit.birdwatcher.repo.RegionRepository;



import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
@RequestMapping("/birds")
public class BirdController {

    @Resource
    private BirdRepository birdRepo;

    @Resource
    private CountryRepository countryRepo;

    @Resource
    private RegionRepository regionRepo;

    @Resource
    private HabitatRepository habitatRepo;

    @GetMapping("")
    public String displayBirds(Model modelBird, Model modelCountry, Model modelRegion, Model modelHabitat){
        modelBird.addAttribute("birds", birdRepo.findAll());
        modelCountry.addAttribute("countries", countryRepo.findAll());
        modelRegion.addAttribute("regions", regionRepo.findAll());
        modelHabitat.addAttribute("habitats", habitatRepo.findAll());
        return "birds";
    }


    @GetMapping("/{id}")
    public String findOneBird(Model model, Model modelBird, @PathVariable Long id) {
        model.addAttribute("bird", birdRepo.findById(id).get());
        modelBird.addAttribute("birds", birdRepo.findAll());
        return "bird";
    }

    @PostMapping("/addBird")
    public String addCountry(@RequestParam String regionsId, @RequestParam String habitatsId,
                             @RequestParam String countriesId,@RequestParam String birdName,
                             @RequestParam String birdUrl, @RequestParam String description){

        Bird birdToAdd = new Bird(birdName, birdUrl, description);

        ArrayList<Region> regionList = new ArrayList<>();
        String[] regionsS = regionsId.split(",");
        for(String regionIdString : regionsS){
            Long regionId = Long.parseLong(regionIdString);
            birdToAdd.addRegion(regionRepo.findById(regionId).get());
        }

        ArrayList<Habitat> habitatList = new ArrayList<>();
        String[] habitatsS = habitatsId.split(",");
        for(String habitatIdString : habitatsS){
            Long habitatId = Long.parseLong(habitatIdString);
            birdToAdd.addHabitat(habitatRepo.findById(habitatId).get());
        }

        ArrayList<Country> countryList = new ArrayList<>();
        String[] countriesS = countriesId.split(",");
        for(String countryIdString : countriesS){
            Long countryId = Long.parseLong(countryIdString);
            birdToAdd.addCountry(countryRepo.findById(countryId).get());
        }

        birdRepo.save(birdToAdd);
        return "redirect:/birds";
    }

}
