package com.kosoban.aquacultureexpanded.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

import static com.kosoban.aquacultureexpanded.AquacultureExpandedMod.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> DRESSED_HERRING_BLOCK = register(DressedHerringBlock::new, "dressed_herring");
    public static final RegistryObject<Block> GOLDEN_DRESSED_HERRING_BLOCK = register(GoldenDressedHerringBlock::new, "golden_dressed_herring");
    public static final RegistryObject<Block> ENCHANTED_DRESSED_HERRING_BLOCK = register(EnchantedDressedHerringBlock::new, "enchanted_dressed_herring");

    public static RegistryObject<Block> register(@Nonnull Supplier<Block> initializer, @Nonnull String name) {
        return BLOCKS.register(name, initializer);
    }
}
