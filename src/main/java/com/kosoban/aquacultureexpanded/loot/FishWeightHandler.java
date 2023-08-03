package com.kosoban.aquacultureexpanded.loot;

import com.kosoban.aquacultureexpanded.items.ModItems;
import com.teammetallurgy.aquaculture.api.AquacultureAPI;

public class FishWeightHandler {
    public static void registerFishData() {
        AquacultureAPI.FISH_DATA.add(ModItems.PRUSSIAN_CARP.get(), 1, 10, 1);
    }
}
