package com.kosoban.aquacultureexpanded.items;

import com.kosoban.aquacultureexpanded.ModCreativeTab;
import com.kosoban.aquacultureexpanded.core.ClassUtil;
import com.teammetallurgy.aquaculture.item.ItemFilletKnife;
import net.minecraft.world.item.Tiers;

public class NetheriteFilletKnife extends ItemFilletKnife {

    public NetheriteFilletKnife() {
        super(Tiers.NETHERITE);
        ClassUtil.updateFieldRecursive(this, "f_41377_", ModCreativeTab.MAIN_TAB);
    }

}
