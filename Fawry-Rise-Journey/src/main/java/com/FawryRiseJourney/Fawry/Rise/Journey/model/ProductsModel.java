package com.FawryRiseJourney.Fawry.Rise.Journey.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "products")
public class ProductsModel {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@NotBlank(message = "Product must has name")
private String name;
@Positive(message = "price cannot be negative")
private float price;
@Positive(message = "quantity cannot be negative")
private int quantity;
private boolean expireable;
private boolean shipable;
@Positive(message = "wheight cannot be negative")
@Nullable
private Double wheight;
@Positive(message = "shipCost cannot be negative")
@Nullable
private Float shipCost;
@Nullable
private LocalDate expirationDate;

}
