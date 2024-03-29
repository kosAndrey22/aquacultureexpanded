package com.kosoban.aquacultureexpanded.items;


import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;

public class Naparocco extends BowlFoodItem {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.7F).build();

    public Naparocco() {
        super(new Item.Properties().food(Naparocco.foodProperties).stacksTo(1));
    }
}
