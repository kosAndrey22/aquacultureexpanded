package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CatfishPie extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(8).saturationMod(1.23F).build();

    public CatfishPie() {
        super(new Item.Properties().food(CatfishPie.foodProperties).stacksTo(64));
    }
}
