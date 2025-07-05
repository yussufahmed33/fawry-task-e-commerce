package com.FawryRiseJourney.Fawry.Rise.Journey.repository;

import com.FawryRiseJourney.Fawry.Rise.Journey.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShippingRepository extends JpaRepository<ProductsModel,Integer> {
    @Query("SELECT p FROM CartModel p WHERE p.shipable = true")
    List<ProductsModel> findShippableProducts();
}
