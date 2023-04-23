package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class PickledHerring extends GlassBottleFoodItem {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.5F).build();

    public PickledHerring() {
        super(new Item.Properties().food(PickledHerring.foodProperties).stacksTo(64));
    }
}
