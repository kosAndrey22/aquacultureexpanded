package com.kosoban.aquacultureexpanded.core;

import com.kosoban.aquacultureexpanded.entity.ModEntities;
import com.kosoban.aquacultureexpanded.items.ModItems;
import com.teammetallurgy.aquaculture.entity.AquaFishEntity;
import com.teammetallurgy.aquaculture.entity.FishType;
import com.teammetallurgy.aquaculture.item.AquaFishBucket;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

import static com.kosoban.aquacultureexpanded.AquacultureExpandedMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FishRegistry {

    public static RegistryObject<Item> register(@Nonnull Supplier<Item> initializer, @Nonnull String name, FishType fishType) {
        RegistryObject<EntityType<AquaFishEntity>> fish = ModEntities.ENTITIES.register(name, () -> EntityType.Builder.<AquaFishEntity>of((f, w) -> new AquaFishEntity(f, w, fishType), MobCategory.WATER_AMBIENT).sized(fishType.getWidth(), fishType.getHeight()).build(MODID + ":" + name));
        ModEntities.fishEntities.add(fish);

        RegistryObject<Item> bucket = ModItems.register(() -> new AquaFishBucket(fish, new Item.Properties().stacksTo(1)), name + "_bucket");
        return ModItems.register(initializer, name);
    }

    @SubscribeEvent
    public static void addFishEntity0Attributes(EntityAttributeCreationEvent event) {
        for (RegistryObject<EntityType<AquaFishEntity>> entityType : ModEntities.fishEntities) {
            event.put(entityType.get(), AbstractFish.createAttributes().build());
        }
    }
}
