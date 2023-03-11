package com.kosoban.aquacultureexpanded.entity;

import com.kosoban.aquacultureexpanded.entity.npc.VillagerTradesRewriter;
import com.teammetallurgy.aquaculture.entity.AquaFishEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

import static com.kosoban.aquacultureexpanded.AquacultureExpandedMod.MODID;

public class ModEntities {

    public static List<RegistryObject<EntityType<AquaFishEntity>>> fishEntities = new ArrayList<>();
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static void setupEntities() {
        registerFishes();
        VillagerTradesRewriter.rewrite();
    }

    private static void registerFishes() {
        for (RegistryObject<EntityType<AquaFishEntity>> fish : fishEntities) {
            SpawnPlacements.register(fish.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AquaFishEntity::canSpawnHere);
        }
    }

}
