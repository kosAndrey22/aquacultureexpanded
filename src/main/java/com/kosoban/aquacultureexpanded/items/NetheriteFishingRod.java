package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import com.teammetallurgy.aquaculture.item.AquaFishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class NetheriteFishingRod extends AquaFishingRodItem {
    public NetheriteFishingRod() {
        super(Tiers.NETHERITE, (new Item.Properties()).durability(1250).tab(ModCreativeTab.MAIN_TAB));
    }
}
