package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.wecancodeit.birdwatcher.model.Country;
import org.wecancodeit.birdwatcher.model.Habitat;
import org.wecancodeit.birdwatcher.model.Region;
import org.wecancodeit.birdwatcher.repo.CountryRepository;
import org.wecancodeit.birdwatcher.repo.HabitatRepository;
import org.wecancodeit.birdwatcher.repo.RegionRepository;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
@RequestMapping("/regions")
public class RegionController {
    @Resource
    private RegionRepository regionRepo;

    @Resource
    private CountryRepository countryRepo;

    @Resource
    private HabitatRepository habitatRepo;

    @GetMapping("")
    public String displayRegions(Model model){
        model.addAttribute("regions", regionRepo.findAll());
        return "regions";
    }
    @GetMapping("/{id}")
    public String findOneRegion(Model model, Model modelAllReg, @PathVariable Long id){
        model.addAttribute("region", regionRepo.findById(id).get());
        modelAllReg.addAttribute("regions", regionRepo.findAll());
        return "region";
    }


    @PostMapping("/addRegion")
    public String addCountry(@RequestParam String regionName, @RequestParam String habitatsId,
                             @RequestParam String countriesId){

        Region regionToAdd = new Region(regionName);

        ArrayList<Habitat> habitatList = new ArrayList<>();
        String[] habitatsS = habitatsId.split(",");
        for(String habitatIdString : habitatsS){
            Long habitatId = Long.parseLong(habitatIdString);
            regionToAdd.addHabitat(habitatRepo.findById(habitatId).get());
        }

        ArrayList<Country> countryList = new ArrayList<>();
        String[] countriesS = countriesId.split(",");
        for(String countryIdString : countriesS){
            Long countryId = Long.parseLong(countryIdString);
            regionToAdd.addCountry(countryRepo.findById(countryId).get());
        }
        regionRepo.save(regionToAdd);
        return "redirect:/regions";

    }

}
