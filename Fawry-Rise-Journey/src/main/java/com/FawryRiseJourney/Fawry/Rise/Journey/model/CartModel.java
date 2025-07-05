package com.FawryRiseJourney.Fawry.Rise.Journey.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "cart")
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
    private int quantity;
    private boolean expireable;
    private boolean shipable;
    @Nullable
    private Double wheight;
    @Nullable
    private Float shipCost;
    @Nullable
    private LocalDate expirationDate;

}

