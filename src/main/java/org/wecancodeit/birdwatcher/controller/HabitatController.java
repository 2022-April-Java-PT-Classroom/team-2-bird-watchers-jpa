package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.birdwatcher.model.Bird;
import org.wecancodeit.birdwatcher.model.Country;
import org.wecancodeit.birdwatcher.model.Habitat;
import org.wecancodeit.birdwatcher.model.Region;
import org.wecancodeit.birdwatcher.repo.CountryRepository;
import org.wecancodeit.birdwatcher.repo.HabitatRepository;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
@RequestMapping("/habitats")
public class HabitatController {
    @Resource
    private HabitatRepository habitatRepo;

    @Resource
    private CountryRepository countryRepo;

    @GetMapping("")
    private  String displayHabitat(Model model, Model modelCountry){
        model.addAttribute("habitats", habitatRepo.findAll());
        modelCountry.addAttribute("countries", countryRepo.findAll());
        return "habitats";
    }

    @GetMapping("/{id}")
    private  String displayHabitat(Model model, @RequestParam Long Id){
        model.addAttribute("habitats", habitatRepo.findById(Id).get());
        return "habitat";
    }

    @PostMapping("/addHabitat")
    public String addCountry(@RequestParam String countriesId, @RequestParam String habitatName){

        Habitat habitatToAdd = new Habitat(habitatName);

        ArrayList<Country> countryList = new ArrayList<>();
        String[] countriesS = countriesId.split(",");
        for(String countryIdString : countriesS){
            Long countryId = Long.parseLong(countryIdString);
            habitatToAdd.addCountry(countryRepo.findById(countryId).get());
        }

        habitatRepo.save(habitatToAdd);
        return "redirect:/habitats";
    }

}
