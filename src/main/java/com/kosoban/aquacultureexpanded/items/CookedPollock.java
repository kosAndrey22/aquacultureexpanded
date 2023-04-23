package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedPollock extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.7F).build();

    public CookedPollock() {
        super(new Item.Properties().food(CookedPollock.foodProperties).stacksTo(64));
    }
}
