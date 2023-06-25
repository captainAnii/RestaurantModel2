package com.geekster.RestaurantModel.service;

import com.geekster.RestaurantModel.model.Restaurant;
import com.geekster.RestaurantModel.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    IRestaurantRepository iRestaurantRepository;

    public String addRestaurants(List<Restaurant> listOfRestaurants) {

        Iterable<Restaurant> addedRestaurants = iRestaurantRepository.saveAll(listOfRestaurants);
        if(addedRestaurants!=null){
            return "Yes";
        }else{
            return "No";
        }
    }

    public Iterable<Restaurant> fetchAllRestaurants() {
        Iterable<Restaurant> allRestaurants = iRestaurantRepository.findAll();
        return allRestaurants;
    }
    public Restaurant getRestaurantById(Long id) {
        Optional<Restaurant> restaurantOptional = iRestaurantRepository.findById(id);
        return restaurantOptional.orElse(null);
    }


    public Restaurant updateRestaurantSpecialty(Long id, String restaurantSpecialty) {
        Optional<Restaurant> restaurantOptional = iRestaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            restaurant.setRestaurantSpeciality(restaurantSpecialty);;
            return iRestaurantRepository.save(restaurant);
        }
        return null;
    }

    public void removeUserById(long restaurantId) {
        iRestaurantRepository.deleteById(restaurantId);
    }



}
