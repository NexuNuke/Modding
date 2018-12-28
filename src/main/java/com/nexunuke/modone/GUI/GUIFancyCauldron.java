package com.nexunuke.modone.GUI;

import com.nexunuke.modone.blocks.ContainerFancyCauldron;
import com.nexunuke.modone.blocks.TileFancyCauldron;
import com.nexunuke.modone.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

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
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        if (cauldron.getClientProgress() > 0) {
            drawString(mc.fontRenderer, "Progress: " + (100 - cauldron.getClientProgress() * 100 / TileFancyCauldron.MAX_PROGRESS) + "%", guiLeft + 10, guiTop + 50, 0xffffff);
        }
    }


}
