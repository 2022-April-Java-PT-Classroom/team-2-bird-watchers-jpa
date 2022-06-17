package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.birdwatcher.model.Bird;
import org.wecancodeit.birdwatcher.repo.BirdRepository;

import org.wecancodeit.birdwatcher.repo.CountryRepository;
import org.wecancodeit.birdwatcher.repo.RegionRepository;



import javax.annotation.Resource;

@Controller
@RequestMapping("/birds")
public class BirdController {

    @Resource
    private BirdRepository birdRepo;

    @Resource
    private CountryRepository countryRepo;

    @Resource
    private RegionRepository regionRepo;

    @GetMapping("")
    public String displayBirds(Model modelBird, Model modelCountry, Model modelRegion){
        modelBird.addAttribute("birds", birdRepo.findAll());
        modelCountry.addAttribute("countries", countryRepo.findAll());
        modelRegion.addAttribute("regions", regionRepo.findAll());
        return "birds";
    }


    @GetMapping("/{id}")
    public String findOneBird(Model model, @PathVariable Long id) {
        model.addAttribute("bird", birdRepo.findById(id).get());
        return "bird";
    }

}


