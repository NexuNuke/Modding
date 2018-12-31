package com.nexunuke.modone.GUI;

import com.nexunuke.modone.blocks.ContainerFancyCauldron;
import com.nexunuke.modone.blocks.FancyCauldron;
import com.nexunuke.modone.blocks.TileFancyCauldron;
import com.nexunuke.modone.config.GeneralConfig;
import com.nexunuke.modone.states.CauldronState;
import com.nexunuke.modone.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

import java.util.Collections;

public class GUIFancyCauldron extends GuiContainer {
    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(Reference.MODID, "textures/gui/fancy_cauldron_gui.png");
    private TileFancyCauldron cauldron;

    public GUIFancyCauldron(TileFancyCauldron tileEntity, ContainerFancyCauldron container) {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;

        cauldron = tileEntity;
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);

        if (mouseX > guiLeft + 10 && mouseX < guiLeft + 112 && mouseY > guiTop + 5 && mouseY < guiTop + 15) {
            drawHoveringText(Collections.singletonList("Energy: " + cauldron.getClientEnergy() + " RF"), mouseX, mouseY, fontRenderer);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        int energy = cauldron.getClientEnergy();
        drawEnergyBar(energy);

        if (cauldron.getClientProgress() > 0) {
            drawString(mc.fontRenderer, "Progress: " + (100 - cauldron.getClientProgress() * 100 / GeneralConfig.MAX_PROGRESS) + "%", guiLeft + 10, guiTop + 50, 0xffffff);
            //drawString(mc.fontRenderer, "Power: ", guiLeft + 10, guiTop + 30, 0xffffff);
        }
        if (cauldron.getState() == CauldronState.OFF) {
            drawString(mc.fontRenderer, "OFF", guiLeft + 10, guiTop + 60, 0xffffff);
        } else if (cauldron.getState() == CauldronState.WORKING) {
            drawString(mc.fontRenderer, "WORKING", guiLeft + 10, guiTop + 60, 0xffffff);
        } else if (cauldron.getState() == CauldronState.NOPOWER) {
            drawString(mc.fontRenderer, "NOPOWER", guiLeft + 10, guiTop + 60, 0xffffff);
        }
    }

    private void drawEnergyBar(int energy) {
        drawRect(guiLeft + 10, guiTop + 5, guiLeft + 112, guiTop + 15, 0xff555555);
        int percentage = energy * 100 / GeneralConfig.MAX_POWER;
        for (int i = 0; i < percentage; i++) {
            drawVerticalLine(guiLeft + 10 + 1 + i, guiTop + 5, guiTop + 14, i % 2 == 0 ? 0xffff0000 : 0xff000000);
        }
    }


}
