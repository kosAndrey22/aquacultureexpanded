package com.kosoban.aquacultureexpanded;

import com.kosoban.aquacultureexpanded.blocks.ModBlocks;
import com.kosoban.aquacultureexpanded.entity.ModEntities;
import com.kosoban.aquacultureexpanded.items.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
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

        bus.addListener(this::commonSetup);
        bus.addListener(this::registerTabs);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModEntities.setupEntities();
        ModItems.setupItems();
    }

    private void registerTabs(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(AquacultureExpandedMod.MODID, "main_tab"), builder -> builder
                .icon(() -> new ItemStack(ModItems.GOLDEN_DRESSED_HERRING.get()))
                .title(Component.translatable("tabs." + AquacultureExpandedMod.MODID + ".main_tab"))
                .displayItems((featureFlagSet, tabOutput, hasOp) -> {
                    ModItems.ITEMS.getEntries().forEach(registryObject -> tabOutput.accept(new ItemStack(registryObject.get())));
                })
        );
    }
}