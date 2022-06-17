package org.wecancodeit.birdwatcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/birds")
public class adminBirdController {


    @GetMapping("")
    public String displayUsers(){
        return "birds";
    }

}