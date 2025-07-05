package com.FawryRiseJourney.Fawry.Rise.Journey.controller;

import com.FawryRiseJourney.Fawry.Rise.Journey.model.ProductsModel;
import com.FawryRiseJourney.Fawry.Rise.Journey.service.ProductsService;
import com.FawryRiseJourney.Fawry.Rise.Journey.service.ShippingService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductsService productsService;
    @Autowired
    ShippingService shippingService;

    @PostMapping("/addproduct")
    public ResponseEntity<String> addProduct(@Valid @RequestBody List<ProductsModel> products) {
        try {
            productsService.addProduct(products);
            return ResponseEntity.ok("Product added successfully");
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/shippableproducts")
    public List<ProductsModel> shippingProducts(){
        return shippingService.shippingProducts();
    }
}
