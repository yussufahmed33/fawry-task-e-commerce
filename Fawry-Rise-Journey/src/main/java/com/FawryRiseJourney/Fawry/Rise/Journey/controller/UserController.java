package com.FawryRiseJourney.Fawry.Rise.Journey.controller;

import com.FawryRiseJourney.Fawry.Rise.Journey.model.ProductsModel;
import com.FawryRiseJourney.Fawry.Rise.Journey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/addtocart")
        public void addtocart(@RequestParam int id,@RequestParam int quantity) {
        userService.addtocart(id, quantity);
    }
    @GetMapping("/viewcart")
    public List viewcart() {return userService.viewcart();}
@GetMapping("/checkout")
    public void checkOut(){
        userService.checkOut();
}
}
