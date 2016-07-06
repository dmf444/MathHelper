package dmf444.MathHelper.Attempt1;

import net.minecraft.client.gui.GuiScreen;

/**
 * Created by TeamDMFMM on 6/28/2016. Code originally written
 * for MathHelper. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class GuiFiller extends GuiScreen{

    public static GuiScreen gui;

    public GuiFiller(GuiScreen screen){
        this.gui = screen;
    }

    public static GuiScreen getGui(){
        return gui;
    }
}
