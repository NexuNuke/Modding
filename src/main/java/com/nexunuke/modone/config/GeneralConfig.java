package com.nexunuke.modone.config;

import com.nexunuke.modone.ModOneMain;
import com.nexunuke.modone.util.Reference;
import net.minecraftforge.common.config.Config;

@Config(modid = Reference.MODID)
public class GeneralConfig {


    public static int MAX_PROGRESS = 40;
    public static int MAX_POWER = 100000;
    public static int RF_PER_TICK_INPUT = 128;
    public static int RF_PER_TICK = 128;
}
