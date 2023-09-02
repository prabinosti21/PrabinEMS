package com.diyo.Event.Management.System.EMS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "food_drinks")
public class FoodAndDrinks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "foodAndDrinksId_generator")
    @SequenceGenerator(name = "foodAndDrinksId_generator", sequenceName = "foodAndDrinksId_sequence")
    private Long foodAndDrinksId;

    @NotBlank(message = "Please provide drink name.")
    private String drinkName;

    @NotBlank(message = "Please provide drink quantity")
    private String drinkQuantity;

    @NotBlank(message = "Please provide drink cost")
    private String drinkCost;

    @NotBlank(message = "Please provide food name.")
    private String foodName;

    @NotBlank(message = "Please provide food quantity")
    private String foodQuantity;

    @NotBlank(message = "Please provide the cost of the food.")
    private String foodCost;
}
