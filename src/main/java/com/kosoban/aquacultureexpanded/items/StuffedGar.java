package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class StuffedGar extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F).build();

    public StuffedGar() {
        super(new Item.Properties().food(StuffedGar.foodProperties).stacksTo(64));
    }
}
