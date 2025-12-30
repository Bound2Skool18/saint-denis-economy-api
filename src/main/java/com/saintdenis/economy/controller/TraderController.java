package com.saintdenis.economy.controller;


import com.saintdenis.economy.model.TraderPrice;
import com.saintdenis.economy.repository.TraderPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/trader")
public class TraderController {

    @Autowired
    private TraderPriceRepository repository;

    @GetMapping("/prices")
    public List<TraderPrice> getPrices() 
    {
        //TraderPrice moonshine = new TraderPrice("Moonshine",30.0, 80.0, 15);
        //TraderPrice wagon = new TraderPrice("Trader Wagon Delivery", 50.0, 175.0, 25);
        //return List.of(moonshine, wagon);
        
        return repository.findAll();
    }

    @PostMapping("/prices")
    public TraderPrice createPrice(@RequestBody TraderPrice traderPrice) {
        //TODO: process POST request
        
        return repository.save(traderPrice);
    }

    @PutMapping("/prices/{id}")
    public ResponseEntity<TraderPrice> updatePrice(
        @PathVariable Long id, 
        @RequestBody TraderPrice updatedPrice) {
        //TODO: process PUT request
        
        return repository.findById(id).map(existingPrice -> {
            existingPrice.setProductName(updatedPrice.getProductName());
            existingPrice.setBuyPrice(updatedPrice.getBuyPrice());
            existingPrice.setSellPrice(updatedPrice.getSellPrice());
            existingPrice.setDeliveryTimeMinutes(updatedPrice.getDeliveryTimeMinutes());
            existingPrice.setProfit(updatedPrice.getSellPrice() - updatedPrice.getBuyPrice());

            TraderPrice saved = repository.save(existingPrice);
            return ResponseEntity.ok(saved);
        })
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/prices/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable Long id) {
        if (repository.existsById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}

