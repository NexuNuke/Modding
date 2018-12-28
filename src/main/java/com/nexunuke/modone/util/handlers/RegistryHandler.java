package com.nexunuke.modone.util.handlers;

import com.nexunuke.modone.ModOneMain;
import com.nexunuke.modone.blocks.TileFancyCauldron;
import com.nexunuke.modone.init.Blocks;
import com.nexunuke.modone.init.Items;
import com.nexunuke.modone.util.IHasModel;
import com.nexunuke.modone.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(Items.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(Blocks.BLOCKS.toArray(new Block[0]));
        GameRegistry.registerTileEntity(TileFancyCauldron.class, new ResourceLocation(Reference.MODID, "cauldron_fancy"));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for(Item item : Items.ITEMS)
        {
            if(item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
            }
        }
        for(Block block : Blocks.BLOCKS)
        {
            if(block instanceof  IHasModel)
            {
                ((IHasModel)block).registerModels();
            }
        }
    }
}
