package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.birdwatcher.model.Bird;
import org.wecancodeit.birdwatcher.model.Country;
import org.wecancodeit.birdwatcher.model.Region;
import org.wecancodeit.birdwatcher.model.Travel;
import org.wecancodeit.birdwatcher.repo.BirdRepository;
import org.wecancodeit.birdwatcher.repo.CountryRepository;
import org.wecancodeit.birdwatcher.repo.RegionRepository;
import org.wecancodeit.birdwatcher.repo.TravelRepository;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/travel")
public class TravelController {

    @Resource
    private CountryRepository countryRepo;
    @Resource
    private RegionRepository regionRepo;
    @Resource
    private BirdRepository birdRepo;
    @Resource
    private TravelRepository travelRepo;

    @GetMapping("")
    public String displayTravel(Model modelAllCon, Model modelAllReg, Model modelAllBird, Model modelAllTra){
        modelAllCon.addAttribute("countries", countryRepo.findAll());
        modelAllBird.addAttribute("birds", birdRepo.findAll());
        modelAllReg.addAttribute("regions", regionRepo.findAll());
        modelAllTra.addAttribute("travels", travelRepo.findAll());
        return "travel";
    }

    @GetMapping("/{id}")
    public String displayTravel(Model modelAllTra, @RequestParam Long id){
        modelAllTra.addAttribute("travels", travelRepo.findById(id).get());
        return "single-travel";
    }

    @PostMapping("/addTravel")
    public String addTravel(@RequestParam String userName, @RequestParam String wishes,
                            /*@RequestParam Long regionId,*/ @RequestParam Long countryId,
                            @RequestParam String birdsId){

        Date date = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); //"MM/dd/yyyy hh:mm:ss"
        //String dateStr = df.format(date);

        Country country = countryRepo.findById(countryId).get();
        //Region region = regionRepo.findById(regionId).get();
        Travel travelToAdd = new Travel(userName, date, wishes, country/*,  region*/);

        ArrayList<Bird> BirdList = new ArrayList<>();
        String[] birdS = birdsId.split(",");
        for(String birdIdString : birdS){
            Long birdId = Long.parseLong(birdIdString);
            travelToAdd.addBird(birdRepo.findById(birdId).get());
        }
        travelRepo.save(travelToAdd);
        return "redirect:/travel";
    }
}
