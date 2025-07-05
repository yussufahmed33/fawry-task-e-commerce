package com.FawryRiseJourney.Fawry.Rise.Journey.repository;

import com.FawryRiseJourney.Fawry.Rise.Journey.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartModel,Integer> {
}
