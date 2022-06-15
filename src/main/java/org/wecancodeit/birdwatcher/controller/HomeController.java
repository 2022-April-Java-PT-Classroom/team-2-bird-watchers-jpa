package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wecancodeit.birdwatcher.repo.CountryRepository;

import javax.annotation.Resource;

@Controller
public class HomeController {

    @Resource
    private CountryRepository countryRep;

    @GetMapping("/")
    public String displayHome(Model model){
        model.addAttribute("countries", countryRep.findAll());
        return "home";
    }
}
