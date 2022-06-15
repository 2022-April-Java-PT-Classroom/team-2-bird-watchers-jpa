package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.birdwatcher.model.Country;
import org.wecancodeit.birdwatcher.repo.CountryRepository;

import javax.annotation.Resource;

@Controller
@RequestMapping("/countries")
public class CountryController {

    @Resource
    private CountryRepository countryRepo;

    @GetMapping("")
    public String displayCountries(Model model){
        model.addAttribute("countries", countryRepo.findAll());
        return "countries";
    }
    @GetMapping("/{id}")
    public String findOneCountry(Model model, @PathVariable Long id){
        model.addAttribute("country", countryRepo.findById(id).get());
        return "country";
    }
    @PostMapping("/addCountry")
    public String addCountry(@RequestParam String countryName,@RequestParam String region, @RequestParam String habitat){
        Country countryToAdd = new Country(countryName, region, habitat);
        countryRepo.save(countryToAdd);
        return "redirect:/countries";

    }
}
