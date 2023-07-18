package com.kosoban.aquacultureexpanded.blocks;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class EnchantedDressedHerringBlock extends DressedHerringBlock {
    public EnchantedDressedHerringBlock() {
        super (BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOL).lightLevel((p_50878_) -> 4), 1.2F);
    }

    protected void applyEffects(Player p_51189_) {
        p_51189_.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1));
        p_51189_.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0));
        p_51189_.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0));
        p_51189_.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3));
    }
}
