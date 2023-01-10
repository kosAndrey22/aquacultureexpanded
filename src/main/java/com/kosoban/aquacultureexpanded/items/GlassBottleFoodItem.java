package com.kosoban.aquacultureexpanded.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class GlassBottleFoodItem extends Item {
    public GlassBottleFoodItem(Properties pProperties) {
        super(pProperties.craftRemainder(Items.GLASS_BOTTLE));
    }

    public ItemStack finishUsingItem(ItemStack p_40684_, Level p_40685_, LivingEntity p_40686_) {
        ItemStack itemstack = super.finishUsingItem(p_40684_, p_40685_, p_40686_);
        if (p_40686_ instanceof Player && !((Player)p_40686_).getAbilities().instabuild) {
            ((Player) p_40686_).addItem(new ItemStack(Items.GLASS_BOTTLE));
            return p_40684_;
        }
        return itemstack;
    }
}
