package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class TunaPate extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).build();

    public TunaPate() {
        super(new Item.Properties().tab(ModCreativeTab.MAIN_TAB).food(TunaPate.foodProperties).stacksTo(64));
    }
}
