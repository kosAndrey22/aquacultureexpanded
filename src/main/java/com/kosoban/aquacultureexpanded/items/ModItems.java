package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import com.teammetallurgy.aquaculture.item.AquaFishingRodItem;
import com.teammetallurgy.aquaculture.item.ItemFilletKnife;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.kosoban.aquacultureexpanded.AquacultureExpandedMod.MODID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> CANNED_COD_LIVER = ITEMS.register("canned_cod_liver", () -> new CannedCodLiver());
    public static final RegistryObject<Item> CAPTAINS_FISH_STEAK = ITEMS.register("captains_fish_steak", () -> new CaptainsFishSteak());
    public static final RegistryObject<Item> CATFISH_PIE = ITEMS.register("catfish_pie", () -> new CatfishPie());
    public static final RegistryObject<Item> CHOWDER = ITEMS.register("chowder", () -> new Chowder());
    public static final RegistryObject<Item> COD_LIVER = ITEMS.register("cod_liver", () -> new CodLiver());
    public static final RegistryObject<Item> COOKED_CAPTAINS_FISH_STEAK = ITEMS.register("cooked_captains_fish_steak", () -> new CookedCaptainsFishSteak());
    public static final RegistryObject<Item> COOKED_POLLOCK = ITEMS.register("cooked_pollock", () -> new CookedPollock());
    public static final RegistryObject<Item> DRIED_BLUEGILL = ITEMS.register("dried_bluegill", () -> new DriedBluegill());
    public static final RegistryObject<Item> DRIED_MINNOW = ITEMS.register("dried_minnow", () -> new DriedMinnow());
    public static final RegistryObject<Item> DRIED_PERCH = ITEMS.register("dried_perch", () -> new DriedPerch());
    public static final RegistryObject<Item> PICKLED_HERRING = ITEMS.register("pickled_herring", () -> new PickledHerring());
    public static final RegistryObject<Item> LOHIKEITTO = ITEMS.register("lohikeitto", () -> new Lohikeitto());
    public static final RegistryObject<Item> NAPAROCCO = ITEMS.register("naparocco", () -> new Naparocco());
    public static final RegistryObject<Item> SANDWICH_WITH_TUNA = ITEMS.register("sandwich_with_tuna", () -> new SandwichWithTuna());
    public static final RegistryObject<Item> STUFFED_GAR = ITEMS.register("stuffed_gar", () -> new StuffedGar());
    public static final RegistryObject<Item> TUNA_PATE = ITEMS.register("tuna_pate", () -> new TunaPate());
    public static final RegistryObject<Item> UKHA = ITEMS.register("ukha", () -> new Ukha());

    public static final RegistryObject<Item> DRESSED_HERRING = ITEMS.register("dressed_herring", () -> new DressedHerring());
    public static final RegistryObject<Item> GOLDEN_DRESSED_HERRING = ITEMS.register("golden_dressed_herring", () -> new GoldenDressedHerring());
    public static final RegistryObject<Item> ENCHANTED_DRESSED_HERRING = ITEMS.register("enchanted_dressed_herring", () -> new EnchantedDressedHerring());

    public static final RegistryObject<Item> NETHERITE_FISHING_ROD = ITEMS.register("netherite_fishing_rod", () -> new NetheriteFishingRod());

    public static final RegistryObject<Item> NETHERITE_FILLET_KNIFE = ITEMS.register("netherite_fillet_knife", () -> new NetheriteFilletKnife());
}
