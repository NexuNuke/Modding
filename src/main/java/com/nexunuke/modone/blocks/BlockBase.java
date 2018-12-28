package com.nexunuke.modone.blocks;

import com.nexunuke.modone.ModOneMain;
import com.nexunuke.modone.init.Blocks;
import com.nexunuke.modone.init.Items;
import com.nexunuke.modone.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import static com.nexunuke.modone.ModOneMain.modOneTab;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(modOneTab);

        Blocks.BLOCKS.add(this);
        Items.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels(){
        ModOneMain.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
