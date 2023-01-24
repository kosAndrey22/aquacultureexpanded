package com.kosoban.aquacultureexpanded.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.kosoban.aquacultureexpanded.ModCreativeTab;
import com.teammetallurgy.aquaculture.item.ItemFilletKnife;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import javax.annotation.Nonnull;

public class NetheriteFilletKnife extends SwordItem {

    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> attributes;

//    private final ItemFilletKnife filletKnife;

    public NetheriteFilletKnife() {
        super(Tiers.NETHERITE, 0, 0.0F, (new Item.Properties()).tab(ModCreativeTab.MAIN_TAB).defaultDurability((int)((float)Tiers.NETHERITE.getUses() * 0.75F)));
//        filletKnife = new ItemFilletKnife(Tiers.NETHERITE);

        Tiers material = Tiers.NETHERITE;
        this.attackDamage = material.getAttackDamageBonus() / 2;

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -2.2F, AttributeModifier.Operation.ADDITION));
        this.attributes = builder.build();
    }

    @Override
    public boolean canApplyAtEnchantingTable(@Nonnull ItemStack stack, Enchantment enchantment) {
//        return filletKnife.canApplyAtEnchantingTable(stack, enchantment);
        return super.canApplyAtEnchantingTable(stack, enchantment) && canApplyEnchantment(enchantment);
    }

    private boolean canApplyEnchantment(Enchantment enchantment) {
//        return filletKnife.canApplyEnchantment(enchantment);
        return enchantment != Enchantments.MOB_LOOTING && enchantment != Enchantments.SWEEPING_EDGE;
    }

    @Override
    public float getDamage() {
        return this.attackDamage;
//        return filletKnife.getDamage();
    }

    @Override
    @Nonnull
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@Nonnull EquipmentSlot slotType) {
//        return filletKnife.getDefaultAttributeModifiers(slotType);
        return slotType == EquipmentSlot.MAINHAND ? this.attributes : ImmutableMultimap.of();
    }
}
