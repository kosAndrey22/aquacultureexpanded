package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedPollock extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.7F).build();

    public CookedPollock() {
        super(new Item.Properties().tab(ModCreativeTab.MAIN_TAB).food(CookedPollock.foodProperties).stacksTo(64));
    }
}
