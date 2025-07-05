package com.FawryRiseJourney.Fawry.Rise.Journey.repository;

import com.FawryRiseJourney.Fawry.Rise.Journey.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<ProductsModel,Integer> {
}
