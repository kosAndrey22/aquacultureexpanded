package com.kosoban.aquacultureexpanded.client;

import com.kosoban.aquacultureexpanded.client.renderer.entity.AquaExpFishRenderer;
import com.kosoban.aquacultureexpanded.entity.ModEntities;
import com.kosoban.aquacultureexpanded.items.ModItems;
import com.teammetallurgy.aquaculture.client.ClientHandler;
import com.teammetallurgy.aquaculture.entity.AquaFishEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static com.kosoban.aquacultureexpanded.AquacultureExpandedMod.MODID;
@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientHandlerExp extends ClientHandler {

    public static void setupClient() {
        registerFishingRodModelProperties(ModItems.NETHERITE_FISHING_ROD.get());
    }

    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        for (RegistryObject<EntityType<AquaFishEntity>> fish : ModEntities.fishEntities) {
            event.registerEntityRenderer(fish.get(), (context) -> new AquaExpFishRenderer(context));
        }
    }
}