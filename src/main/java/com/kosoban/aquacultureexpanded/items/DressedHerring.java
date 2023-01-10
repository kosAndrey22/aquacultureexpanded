package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import com.kosoban.aquacultureexpanded.blocks.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class DressedHerring extends BlockItem {
    public DressedHerring() {
        super(ModBlocks.DRESSED_HERRING_BLOCK.get(), new Item.Properties().tab(ModCreativeTab.MAIN_TAB).stacksTo(1));
    }
}