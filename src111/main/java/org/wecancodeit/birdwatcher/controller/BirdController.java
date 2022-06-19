package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.birdwatcher.model.Bird;
import org.wecancodeit.birdwatcher.repo.BirdRepository;


import javax.annotation.Resource;

@Controller
@RequestMapping("/bird")
public class BirdController {

    @Resource
    private BirdRepository birdRepo;

    @GetMapping("/{id}")
    public String findOneBird(Model model, @PathVariable Long id) {
        model.addAttribute("bird", birdRepo.findById(id).get());
        return "bird";
    }
}
