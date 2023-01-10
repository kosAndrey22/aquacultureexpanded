package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import com.kosoban.aquacultureexpanded.blocks.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Rarity;

public class GoldenDressedHerring extends BlockItem {
    public GoldenDressedHerring() {
        super(ModBlocks.GOLDEN_DRESSED_HERRING_BLOCK.get(), new Properties().tab(ModCreativeTab.MAIN_TAB).stacksTo(1).rarity(Rarity.RARE));
    }
}