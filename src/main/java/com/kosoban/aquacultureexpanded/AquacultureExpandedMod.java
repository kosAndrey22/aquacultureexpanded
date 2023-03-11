package com.kosoban.aquacultureexpanded;

import com.kosoban.aquacultureexpanded.blocks.ModBlocks;
import com.kosoban.aquacultureexpanded.entity.ModEntities;
import com.kosoban.aquacultureexpanded.items.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AquacultureExpandedMod.MODID)
public class AquacultureExpandedMod
{
    public static final String MODID = "aquacultureexpanded";

    public AquacultureExpandedMod() {
        init();
    }

    private void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModEntities.ENTITIES.register(bus);

        bus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModEntities.setupEntities();
        ModItems.setupItems();
    }
}