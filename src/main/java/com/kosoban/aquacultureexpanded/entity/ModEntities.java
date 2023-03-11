package com.kosoban.aquacultureexpanded.entity;

import com.kosoban.aquacultureexpanded.core.FishRegistry;
import com.kosoban.aquacultureexpanded.entity.npc.VillagerTradesRewriter;
import com.kosoban.aquacultureexpanded.items.Beluga;
import com.teammetallurgy.aquaculture.entity.AquaFishEntity;
import com.teammetallurgy.aquaculture.entity.FishType;
import com.teammetallurgy.aquaculture.item.FishItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.kosoban.aquacultureexpanded.AquacultureExpandedMod.MODID;

public class ModEntities {


    public static List<RegistryObject<EntityType<AquaFishEntity>>> fishEntities = new ArrayList<>();
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);


    public static void setupEntities() {
        registerFishes();
        VillagerTradesRewriter.rewrite();
    }

//    public static RegistryObject<EntityType<AquaFishEntity>> register(@Nonnull Supplier<EntityType<AquaFishEntity>> initializer, @Nonnull String name) {
//        return ENTITIES.register(name, initializer);
//    }
//
    private static void registerFishes() {
        for (RegistryObject<EntityType<AquaFishEntity>> fish : fishEntities) {
            SpawnPlacements.register(fish.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AquaFishEntity::canSpawnHere);
        }
    }

}
