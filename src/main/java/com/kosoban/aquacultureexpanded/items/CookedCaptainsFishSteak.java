package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedCaptainsFishSteak extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.75F).build();

    public CookedCaptainsFishSteak() {
        super(new Item.Properties().food(CookedCaptainsFishSteak.foodProperties).stacksTo(64));
    }
}
