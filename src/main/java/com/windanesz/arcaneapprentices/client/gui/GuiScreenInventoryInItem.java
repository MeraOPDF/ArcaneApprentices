package com.windanesz.arcaneapprentices.client.gui;

import com.windanesz.arcaneapprentices.ArcaneApprentices;
import com.windanesz.arcaneapprentices.inventory.ContainerInventoryInItemStack;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiScreenInventoryInItem extends GuiContainer {

	private final ResourceLocation GUI_BACKGROUND;

	public GuiScreenInventoryInItem(IInventory inventory, EntityPlayer player) {
		super(new ContainerInventoryInItemStack(player.inventory, inventory, player));
		this.xSize = 176;
		this.ySize = 170;
		this.GUI_BACKGROUND = new ResourceLocation(ArcaneApprentices.MODID, "textures/gui/gui_" + inventory.getSizeInventory() + ".png");
	}

	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GUI_BACKGROUND);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

	}

	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

}
