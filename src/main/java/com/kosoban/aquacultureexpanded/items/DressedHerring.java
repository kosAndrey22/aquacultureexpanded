package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.blocks.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class DressedHerring extends BlockItem {
    public DressedHerring() {
        super(ModBlocks.DRESSED_HERRING_BLOCK.get(), new Item.Properties().stacksTo(1));
    }
}