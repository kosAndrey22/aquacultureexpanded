package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class SandwichWithTuna extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.5F).build();

    public SandwichWithTuna() {
        super(new Item.Properties().food(SandwichWithTuna.foodProperties).stacksTo(64));
    }
}
