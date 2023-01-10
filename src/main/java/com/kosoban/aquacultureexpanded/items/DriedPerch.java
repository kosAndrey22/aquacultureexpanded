package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class DriedPerch extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();

    public DriedPerch() {
        super(new Item.Properties().tab(ModCreativeTab.MAIN_TAB).food(DriedPerch.foodProperties).stacksTo(64));
    }
}
