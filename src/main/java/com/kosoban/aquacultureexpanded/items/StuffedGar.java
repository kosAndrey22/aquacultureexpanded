package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class StuffedGar extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F).build();

    public StuffedGar() {
        super(new Item.Properties().tab(ModCreativeTab.MAIN_TAB).food(StuffedGar.foodProperties).stacksTo(64));
    }
}
