package com.kosoban.aquacultureexpanded;

import com.kosoban.aquacultureexpanded.blocks.ModBlocks;
import com.kosoban.aquacultureexpanded.items.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AquacultureExpandedMod.MODID)
public class AquacultureExpandedMod
{
    public static final String MODID = "aquacultureexpanded";

    public AquacultureExpandedMod() {
        registerObjects();
    }

    public void registerObjects() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
    }
}