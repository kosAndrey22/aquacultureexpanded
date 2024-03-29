package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;

public class Ukha extends BowlFoodItem {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.6F).build();

    public Ukha() {
        super(new Item.Properties().food(Ukha.foodProperties).stacksTo(1));
    }
}
