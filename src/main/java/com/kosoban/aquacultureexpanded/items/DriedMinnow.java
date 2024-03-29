package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class DriedMinnow extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.7F).fast().build();

    public DriedMinnow() {
        super(new Item.Properties().food(DriedMinnow.foodProperties).stacksTo(64));
    }
}
