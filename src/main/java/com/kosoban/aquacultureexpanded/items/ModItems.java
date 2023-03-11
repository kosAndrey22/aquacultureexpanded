package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.core.FishRegistry;
import com.teammetallurgy.aquaculture.client.ClientHandler;
import com.teammetallurgy.aquaculture.entity.FishType;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

import static com.kosoban.aquacultureexpanded.AquacultureExpandedMod.MODID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Food
    public static final RegistryObject<Item> CANNED_COD_LIVER = register(CannedCodLiver::new, "canned_cod_liver");
    public static final RegistryObject<Item> CAPTAINS_FISH_STEAK = register(CaptainsFishSteak::new, "captains_fish_steak");
    public static final RegistryObject<Item> CATFISH_PIE = register(CatfishPie::new, "catfish_pie");
    public static final RegistryObject<Item> CHOWDER = register(Chowder::new, "chowder");
    public static final RegistryObject<Item> COD_LIVER = register(CodLiver::new, "cod_liver");
    public static final RegistryObject<Item> COOKED_CAPTAINS_FISH_STEAK = register(CookedCaptainsFishSteak::new, "cooked_captains_fish_steak");
    public static final RegistryObject<Item> COOKED_POLLOCK = register(CookedPollock::new, "cooked_pollock");
    public static final RegistryObject<Item> DRIED_BLUEGILL = register(DriedBluegill::new, "dried_bluegill");
    public static final RegistryObject<Item> DRIED_MINNOW = register(DriedMinnow::new, "dried_minnow");
    public static final RegistryObject<Item> DRIED_PERCH = register(DriedPerch::new, "dried_perch");
    public static final RegistryObject<Item> PICKLED_HERRING = register(PickledHerring::new, "pickled_herring");
    public static final RegistryObject<Item> LOHIKEITTO = register(Lohikeitto::new, "lohikeitto");
    public static final RegistryObject<Item> NAPAROCCO = register(Naparocco::new, "naparocco");
    public static final RegistryObject<Item> SANDWICH_WITH_TUNA = register(SandwichWithTuna::new, "sandwich_with_tuna");
    public static final RegistryObject<Item> STUFFED_GAR = register(StuffedGar::new, "stuffed_gar");
    public static final RegistryObject<Item> TUNA_PATE = register(TunaPate::new, "tuna_pate");
    public static final RegistryObject<Item> UKHA = register(Ukha::new, "ukha");
    public static final RegistryObject<Item> DRESSED_HERRING = register(DressedHerring::new, "dressed_herring");
    public static final RegistryObject<Item> GOLDEN_DRESSED_HERRING = register(GoldenDressedHerring::new, "golden_dressed_herring");
    public static final RegistryObject<Item> ENCHANTED_DRESSED_HERRING = register(EnchantedDressedHerring::new, "enchanted_dressed_herring");

    // Tools
    public static final RegistryObject<Item> NETHERITE_FISHING_ROD = register(NetheriteFishingRod::new, "netherite_fishing_rod");
    public static final RegistryObject<Item> NETHERITE_FILLET_KNIFE = register(NetheriteFilletKnife::new, "netherite_fillet_knife");

    // Fish
    public static final RegistryObject<Item> BELUGA = FishRegistry.register(Beluga::new, "beluga", FishType.LARGE);
//    public static final RegistryObject<Item> BELUGA = register(Beluga::new, "beluga");

    public static void setupItems() {
        ClientHandler.registerFishingRodModelProperties(NETHERITE_FISHING_ROD.get());
    }

    public static RegistryObject<Item> register(@Nonnull Supplier<Item> initializer, @Nonnull String name) {
        return ITEMS.register(name, initializer);
    }
}
