package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import com.kosoban.aquacultureexpanded.blocks.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class EnchantedDressedHerring extends BlockItem {
    public EnchantedDressedHerring() {
        super(ModBlocks.ENCHANTED_DRESSED_HERRING_BLOCK.get(), new Properties().tab(ModCreativeTab.MAIN_TAB).stacksTo(1).rarity(Rarity.EPIC));
    }

    public boolean isFoil(ItemStack p_41172_) {
        return true;
    }
}