package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class Lohikeitto extends Item {
    public static final FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.75F).build();

    public Lohikeitto() {
        super(new Item.Properties().tab(ModCreativeTab.MAIN_TAB).food(Lohikeitto.foodProperties).stacksTo(1));
    }


    public ItemStack finishUsingItem(ItemStack p_40684_, Level p_40685_, LivingEntity p_40686_) {
        super.finishUsingItem(p_40684_, p_40685_, p_40686_);
        if (!p_40685_.isClientSide) {
            p_40686_.curePotionEffects(new ItemStack(Items.MILK_BUCKET));
        }
        if (p_40686_ instanceof ServerPlayer) {
            ServerPlayer serverplayer = (ServerPlayer)p_40686_;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, p_40684_);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (p_40686_ instanceof Player && !((Player)p_40686_).getAbilities().instabuild) {
            p_40684_.shrink(1);
        }
        return new ItemStack(Items.BOWL);
    }
}
