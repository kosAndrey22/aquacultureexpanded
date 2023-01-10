package com.kosoban.aquacultureexpanded.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.kosoban.aquacultureexpanded.AquacultureExpandedMod.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> DRESSED_HERRING_BLOCK = BLOCKS.register("dressed_herring", () -> new DressedHerringBlock());
    public static final RegistryObject<Block> GOLDEN_DRESSED_HERRING_BLOCK = BLOCKS.register("golden_dressed_herring", () -> new GoldenDressedHerringBlock());
    public static final RegistryObject<Block> ENCHANTED_DRESSED_HERRING_BLOCK = BLOCKS.register("enchanted_dressed_herring", () -> new EnchantedDressedHerringBlock());
}
