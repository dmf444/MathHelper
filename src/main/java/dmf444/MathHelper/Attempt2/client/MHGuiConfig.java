package dmf444.MathHelper.Attempt2.client;


import dmf444.MathHelper.Attempt2.ConfigHandler;
import dmf444.MathHelper.MathHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

public class MHGuiConfig extends GuiConfig {

    public MHGuiConfig(GuiScreen guiscreen){
        super(guiscreen, new ConfigElement(ConfigHandler.config.getCategory("Mathhelper")).getChildElements(), MathHelper.MODID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
    }
}
