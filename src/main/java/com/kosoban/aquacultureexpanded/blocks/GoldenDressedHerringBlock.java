package com.kosoban.aquacultureexpanded.blocks;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class GoldenDressedHerringBlock extends DressedHerringBlock {
    protected void applyEffects(Player p_51189_) {
        p_51189_.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
        p_51189_.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0));
    }
}
