package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

}
