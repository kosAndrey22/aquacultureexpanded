package com.kosoban.aquacultureexpanded.core;

import com.kosoban.aquacultureexpanded.entity.ModEntities;
import com.teammetallurgy.aquaculture.client.renderer.entity.AquaFishRenderer;
import com.teammetallurgy.aquaculture.entity.AquaFishEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static com.kosoban.aquacultureexpanded.AquacultureExpandedMod.MODID;
@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientHandler {
    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        for (RegistryObject<EntityType<AquaFishEntity>> fish : ModEntities.fishEntities) {
            event.registerEntityRenderer(fish.get(), (context) -> new AquaFishRenderer(context, false));
        }
    }
}
