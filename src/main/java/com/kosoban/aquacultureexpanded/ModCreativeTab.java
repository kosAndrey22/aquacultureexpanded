package com.kosoban.aquacultureexpanded;

import com.kosoban.aquacultureexpanded.items.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static final CreativeModeTab MAIN_TAB = new CreativeModeTab("main_tab") {
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GOLDEN_DRESSED_HERRING.get());
        }
    };
}
