package com.kosoban.aquacultureexpanded.entity.npc;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class VillagerTradesRewriter {

    private static Map<VillagerProfession, Int2ObjectMap<VillagerTrades.ItemListing[]>> TRADES = VillagerTrades.TRADES;
    public static void rewrite() {
        rewriteClericTrades();
        rewriteFishermanTrades();
        rewriteLibrarianTrades();
    }

    private static void rewriteClericTrades() {
        Int2ObjectMap<VillagerTrades.ItemListing[]> clericTrades = TRADES.get(VillagerProfession.CLERIC);
        @Nullable Item leech = ForgeRegistries.ITEMS.getValue(new ResourceLocation("aquaculture", "leech"));

        addTrade(clericTrades, 3, new VillagerTradesRewriter.EmeraldForItems(leech, 3, 12, 20));
    }

    private static void rewriteFishermanTrades() {
        Int2ObjectMap<VillagerTrades.ItemListing[]> fishermanTrades = TRADES.get(VillagerProfession.FISHERMAN);

        @Nullable Item perch = ForgeRegistries.ITEMS.getValue(new ResourceLocation("aquaculture", "perch"));
        @Nullable Item goldfish = ForgeRegistries.ITEMS.getValue(new ResourceLocation("aquaculture", "goldfish"));

        addTrade(fishermanTrades, 2, new VillagerTradesRewriter.ItemsForEmeralds(perch, 1, 3, 16, 5));
        addTrade(fishermanTrades, 4, new VillagerTradesRewriter.EmeraldForItems(goldfish, 2, 8, 30));
    }

    private static void rewriteLibrarianTrades() {
        Int2ObjectMap<VillagerTrades.ItemListing[]> librarianTrades = TRADES.get(VillagerProfession.LIBRARIAN);
        @Nullable Item arapaima = ForgeRegistries.ITEMS.getValue(new ResourceLocation("aquaculture", "arapaima"));

        addTrade(librarianTrades, 4, new VillagerTradesRewriter.EmeraldForItems(arapaima, 1, 12, 30));
    }

    private static void addTrade(Int2ObjectMap<VillagerTrades.ItemListing[]> trades, int tradeLevel, VillagerTrades.ItemListing newTrade) {
        VillagerTrades.ItemListing[] levelTrades = trades.get(tradeLevel);
        VillagerTrades.ItemListing[] newLevelTrades = addTradeToArray(levelTrades, newTrade);
        trades.put(tradeLevel, newLevelTrades);
    }

    private static VillagerTrades.ItemListing[] addTradeToArray(VillagerTrades.ItemListing[] tradesArray, VillagerTrades.ItemListing newTrade) {
        int oldLength = tradesArray.length;
        VillagerTrades.ItemListing[] newTrades = new VillagerTrades.ItemListing[oldLength + 1];
        for (int i = 0; i < oldLength; i++) {
            newTrades[i] = tradesArray[i];
        }
        newTrades[oldLength] = newTrade;
        return newTrades;
    }

    static class EmeraldForItems implements VillagerTrades.ItemListing {
        private final Item item;
        private final int cost;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;

        public EmeraldForItems(ItemLike p_35657_, int p_35658_, int p_35659_, int p_35660_) {
            this.item = p_35657_.asItem();
            this.cost = p_35658_;
            this.maxUses = p_35659_;
            this.villagerXp = p_35660_;
            this.priceMultiplier = 0.05F;
        }

        public MerchantOffer getOffer(Entity p_219682_, RandomSource p_219683_) {
            ItemStack itemstack = new ItemStack(this.item, this.cost);
            return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.maxUses, this.villagerXp, this.priceMultiplier);
        }
    }

    static class ItemsForEmeralds implements VillagerTrades.ItemListing {
        private final ItemStack itemStack;
        private final int emeraldCost;
        private final int numberOfItems;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;

        public ItemsForEmeralds(Block p_35765_, int p_35766_, int p_35767_, int p_35768_, int p_35769_) {
            this(new ItemStack(p_35765_), p_35766_, p_35767_, p_35768_, p_35769_);
        }

        public ItemsForEmeralds(Item p_35741_, int p_35742_, int p_35743_, int p_35744_) {
            this(new ItemStack(p_35741_), p_35742_, p_35743_, 12, p_35744_);
        }

        public ItemsForEmeralds(Item p_35746_, int p_35747_, int p_35748_, int p_35749_, int p_35750_) {
            this(new ItemStack(p_35746_), p_35747_, p_35748_, p_35749_, p_35750_);
        }

        public ItemsForEmeralds(ItemStack p_35752_, int p_35753_, int p_35754_, int p_35755_, int p_35756_) {
            this(p_35752_, p_35753_, p_35754_, p_35755_, p_35756_, 0.05F);
        }

        public ItemsForEmeralds(ItemStack p_35758_, int p_35759_, int p_35760_, int p_35761_, int p_35762_, float p_35763_) {
            this.itemStack = p_35758_;
            this.emeraldCost = p_35759_;
            this.numberOfItems = p_35760_;
            this.maxUses = p_35761_;
            this.villagerXp = p_35762_;
            this.priceMultiplier = p_35763_;
        }

        public MerchantOffer getOffer(Entity p_219699_, RandomSource p_219700_) {
            return new MerchantOffer(new ItemStack(Items.EMERALD, this.emeraldCost), new ItemStack(this.itemStack.getItem(), this.numberOfItems), this.maxUses, this.villagerXp, this.priceMultiplier);
        }
    }
}
