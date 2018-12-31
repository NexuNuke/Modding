package com.nexunuke.modone.blocks;

import com.nexunuke.modone.ModOneMain;
import com.nexunuke.modone.init.Blocks;
import com.nexunuke.modone.init.Items;
import com.nexunuke.modone.util.IHasModel;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import static com.nexunuke.modone.ModOneMain.modOneTab;

public class BlockBaseCauldron extends BlockCauldron implements IHasModel {

    public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 3);

    public BlockBaseCauldron(String name, Material material){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(modOneTab);

        Blocks.BLOCKS.add(this);
        Items.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
    }

    @Override
    public void registerModels(){
        ModOneMain.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }



}
