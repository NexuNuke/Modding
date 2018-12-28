package com.nexunuke.modone.items;

import com.nexunuke.modone.ModOneMain;
import com.nexunuke.modone.init.Items;
import com.nexunuke.modone.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);

        Items.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        ModOneMain.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
