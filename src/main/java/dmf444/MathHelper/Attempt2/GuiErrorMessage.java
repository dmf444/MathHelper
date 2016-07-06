package dmf444.MathHelper.Attempt2;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiErrorMessage extends GuiButton{

    public GuiErrorMessage(int buttonId, int x, int y, String buttonText) {
        super(buttonId, x, y, buttonText);
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (this.visible) {
            mc.getTextureManager().bindTexture(new ResourceLocation("mathhelper", "textures/gui/wrongAnswer.png"));
            FontRenderer fontrenderer = mc.fontRendererObj;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 0, 160, 15);
            fontrenderer.setUnicodeFlag(true);
            fontrenderer.drawString(this.displayString, (this.xPosition - fontrenderer.getStringWidth(this.displayString) / 2)+80, this.yPosition+3, 16775416);
            fontrenderer.setUnicodeFlag(false);
        }
    }
}
