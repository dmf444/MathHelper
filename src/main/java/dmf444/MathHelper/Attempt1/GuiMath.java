package dmf444.MathHelper.Attempt1;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

/**
 * Created by TeamDMFMM on 6/28/2016. Code originally written
 * for MathHelper. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class GuiMath extends GuiScreen{

    private static GuiScreen guiProper;
    protected int xSize = 176;
    protected int ySize = 166;

    public GuiMath(GuiScreen gui){
        this.guiProper = gui;
    }

    public void initGui()
    {
        this.buttonList.add(new GuiButton(0, xSize+20, ySize+20, 100, 20, "Submit"));
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawGUI();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    private void drawGUI() {
        GL11.glPushMatrix();
        this.mc.renderEngine.bindTexture(new ResourceLocation("mathhelper", "textures/gui/blankGui.png"));
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        GL11.glPopMatrix();
    }

    protected void actionPerformed(GuiButton button) throws IOException
    {
        if(button.id == 0){
            this.mc.displayGuiScreen(null);
            this.mc.displayGuiScreen(new GuiFiller(guiProper));
        }
    }

}
