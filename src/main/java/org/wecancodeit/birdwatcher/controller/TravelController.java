package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.birdwatcher.repo.CountryRepository;

import javax.annotation.Resource;

@Controller
public class TravelController {

    @Resource
    private CountryRepository countryRepo;

    @RequestMapping("/travel")
    public String displayTravel(Model modelAllCon){
        modelAllCon.addAttribute("countries", countryRepo.findAll());
        return "travel";
    }
}
