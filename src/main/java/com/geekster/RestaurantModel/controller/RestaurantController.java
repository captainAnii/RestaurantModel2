package com.geekster.RestaurantModel.controller;

import com.geekster.RestaurantModel.model.Restaurant;
import com.geekster.RestaurantModel.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/RestaurantModel")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    //Creating/adding----------------------------------------------------------------------------------
    @PostMapping("/restaurants")
    public String addRestaurants(@Valid @RequestBody List<Restaurant> listOfRestaurants){
        return restaurantService.addRestaurants(listOfRestaurants);
    }

    //Reading/Fetching---------------------------------------------------------------------------------
    @GetMapping("/allRestaurants")
    public Iterable<Restaurant> fetchAllRestaurants() {
        return restaurantService.fetchAllRestaurants();
    }

    @GetMapping("restaurant/{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        if (restaurant != null) {
            return ResponseEntity.ok(restaurant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //updating-----------------------------------------------------------------------------------------
    @PutMapping("id/{id}/restaurantSpecialty/{restaurantSpecialty}")
    public ResponseEntity<Restaurant> updateRestaurantSpecialty(@PathVariable Long id, @PathVariable String restaurantSpecialty) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurantSpecialty(id, restaurantSpecialty);
        if (updatedRestaurant != null) {
            return ResponseEntity.ok(updatedRestaurant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //deleting---------------------------------------------------------------------------------------
    @DeleteMapping(value = "restaurant/{restaurantId}")
    public void deleteRestaurantById(@PathVariable long restaurantId){
        restaurantService.removeUserById(restaurantId);
    }

}
