package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.wecancodeit.birdwatcher.model.Country;
import org.wecancodeit.birdwatcher.model.Region;
import org.wecancodeit.birdwatcher.repo.RegionRepository;

import javax.annotation.Resource;

@Controller
@RequestMapping("/regions")
public class RegionController {
    @Resource
    private RegionRepository regionRepo;

    @GetMapping("")
    public String displayRegions(Model model){
        model.addAttribute("regions", regionRepo.findAll());
        return "regions";
    }
    @GetMapping("/{id}")
    public String findOneRegion(Model model, @PathVariable Long id){
        model.addAttribute("region", regionRepo.findById(id).get());
        return "region";
    }


    @PostMapping("/addRegion")
    public String addCountry(@RequestParam String regionName, @RequestParam String habitat){
        Region regionToAdd = new Region(regionName, habitat);
        regionRepo.save(regionToAdd);
        return "redirect:/regions";

    }

}


