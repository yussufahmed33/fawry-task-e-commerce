package com.FawryRiseJourney.Fawry.Rise.Journey.service;

import com.FawryRiseJourney.Fawry.Rise.Journey.model.ProductsModel;
import com.FawryRiseJourney.Fawry.Rise.Journey.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;
    public void addProduct(List<ProductsModel> products) {
        for(ProductsModel productsModel:products){
            if(!productsModel.isShipable()){
                productsModel.setWheight(null);
                productsModel.setShipCost(null);
            } else if (!productsModel.isExpireable()) {
                productsModel.setExpirationDate(null);
            }
        productsRepository.save(productsModel);}
    }
}
