package com.geekster.RestaurantModel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long restaurantId;
    @NotEmpty
    private String restaurantName;
    private String restaurantAddress;
    @NotNull
    @Size(min = 10, max = 12)
    private String restaurantNumber;
    private String restaurantSpeciality;
    private int totalStaff;

}
