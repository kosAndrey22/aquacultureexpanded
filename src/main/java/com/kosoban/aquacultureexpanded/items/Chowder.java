package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;

public class Chowder extends BowlFoodItem {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.5F).build();

    public Chowder() {
        super(new Item.Properties().food(Chowder.foodProperties).stacksTo(1));
    }
}
