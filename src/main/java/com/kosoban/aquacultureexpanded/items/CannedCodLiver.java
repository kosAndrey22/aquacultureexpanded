package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CannedCodLiver extends GlassBottleFoodItem {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.98F).build();

    public CannedCodLiver() {
        super(new Item.Properties().food(CannedCodLiver.foodProperties).stacksTo(8));
    }
}
