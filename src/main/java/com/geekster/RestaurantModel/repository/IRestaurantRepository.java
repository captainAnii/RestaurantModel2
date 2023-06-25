package com.geekster.RestaurantModel.repository;

import com.geekster.RestaurantModel.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends CrudRepository<Restaurant, Long> {
}
