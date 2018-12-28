package com.nexunuke.modone.init;

import com.nexunuke.modone.blocks.BlockBase;
import com.nexunuke.modone.blocks.FancyCauldron;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class Blocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block CAULDRON_FANCY = new FancyCauldron("cauldron_fancy", Material.IRON);

}
