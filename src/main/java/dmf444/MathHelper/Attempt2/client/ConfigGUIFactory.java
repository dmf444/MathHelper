package dmf444.MathHelper.Attempt2.client;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

import java.util.Set;

public class ConfigGUIFactory implements IModGuiFactory {

    @Override
    public void initialize(Minecraft minecraftInstance) {


    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {

        return MHGuiConfig.class;
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {

        return null;
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {

        return null;
    }

}