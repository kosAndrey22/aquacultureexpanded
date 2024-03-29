package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CodLiver extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).build();

    public CodLiver() {
        super(new Item.Properties().food(CodLiver.foodProperties));
    }
}
