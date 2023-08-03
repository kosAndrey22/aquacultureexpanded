package com.kosoban.aquacultureexpanded;

import com.kosoban.aquacultureexpanded.loot.FishWeightHandler;
import com.mojang.logging.LogUtils;
import com.kosoban.aquacultureexpanded.blocks.ModBlocks;
import com.kosoban.aquacultureexpanded.entity.ModEntities;
import com.kosoban.aquacultureexpanded.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(AquacultureExpandedMod.MODID)
public class AquacultureExpandedMod
{
    public static final String MODID = "aquacultureexpanded";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AquacultureExpandedMod.MODID);
    public static final RegistryObject<CreativeModeTab> GROUP = CREATIVE_TABS.register("tab", () -> new CreativeModeTab.Builder(CreativeModeTab.Row.TOP,0)
            .icon(() -> new ItemStack(ModItems.GOLDEN_DRESSED_HERRING.get()))
            .title(Component.translatable("tabs." + AquacultureExpandedMod.MODID + ".main_tab"))
            .displayItems((featureFlagSet, tabOutput) -> {
                ModItems.ITEMS.getEntries().forEach(registryObject -> tabOutput.accept(new ItemStack(registryObject.get())));
            }).build()
    );

    public AquacultureExpandedMod() {
        init();
    }

    private void init() {
        LOGGER.info("AquacultureExpandedMod Setup");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        CREATIVE_TABS.register(bus);

        bus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModEntities.setupEntities();
        ModItems.setupItems();
        FishWeightHandler.registerFishData();
    }
}