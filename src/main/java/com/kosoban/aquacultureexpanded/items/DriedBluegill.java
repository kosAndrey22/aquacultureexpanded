package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class DriedBluegill extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).fast().build();

    public DriedBluegill() {
        super(new Item.Properties().tab(ModCreativeTab.MAIN_TAB).food(DriedBluegill.foodProperties).stacksTo(64));
    }
}
