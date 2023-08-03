package com.kosoban.aquacultureexpanded.client.renderer.entity;

import com.kosoban.aquacultureexpanded.AquacultureExpandedMod;
import com.teammetallurgy.aquaculture.client.ClientHandler;
import com.teammetallurgy.aquaculture.client.renderer.entity.AquaFishRenderer;
import com.teammetallurgy.aquaculture.client.renderer.entity.model.FishSmallModel;
import com.teammetallurgy.aquaculture.entity.AquaFishEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class AquaExpFishRenderer extends AquaFishRenderer {
    private static final ResourceLocation DEFAULT_LOCATION = new ResourceLocation(AquacultureExpandedMod.MODID, "textures/entity/prussian_carp.png");
    private final FishSmallModel<AquaFishEntity> smallModel;

    public AquaExpFishRenderer(EntityRendererProvider.Context context) {
        super(context, false);
        this.smallModel = new FishSmallModel<>(context.bakeLayer(ClientHandler.SMALL_MODEL));
    }

    @Override
    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull AquaFishEntity fishEntity) {
        ResourceLocation location = ForgeRegistries.ENTITY_TYPES.getKey(fishEntity.getType());
        if (location != null) {
            return new ResourceLocation(AquacultureExpandedMod.MODID, "textures/entity/" + location.getPath() + ".png");
        }
        return DEFAULT_LOCATION;
    }
}
