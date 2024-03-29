package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CaptainsFishSteak extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.7F).build();

    public CaptainsFishSteak() {
        super(new Item.Properties().food(CaptainsFishSteak.foodProperties).stacksTo(64));
    }
}
