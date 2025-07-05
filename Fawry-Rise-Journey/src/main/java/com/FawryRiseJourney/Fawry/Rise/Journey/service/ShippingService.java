package com.FawryRiseJourney.Fawry.Rise.Journey.service;

import com.FawryRiseJourney.Fawry.Rise.Journey.model.ProductsModel;
import com.FawryRiseJourney.Fawry.Rise.Journey.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingService {
@Autowired
ShippingRepository shippingRepository;
public List<ProductsModel> shippingProducts() {
    List<ProductsModel> products = shippingRepository.findShippableProducts();
    for(ProductsModel product : products) {
        System.out.println("name: " + product.getName() + " weight: " + product.getWheight());
    }
   return products;
}
}
