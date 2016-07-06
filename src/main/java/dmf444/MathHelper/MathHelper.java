package dmf444.MathHelper;


import dmf444.MathHelper.Attempt1.GuiOverrideEvent;
import dmf444.MathHelper.Attempt2.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import java.io.File;

@Mod(modid = MathHelper.MODID, version = MathHelper.VERSION, guiFactory = "dmf444.MathHelper.Attempt2.client.ConfigGUIFactory", clientSideOnly = true)
public class MathHelper {

    @Mod.Instance(value = "mathhelper")
    public static MathHelper instance;

    public static final String MODID = "mathhelper";
    public static final String VERSION = "1.0";
    public static SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel("MathHelper");



    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        ConfigHandler.init(new File(event.getModConfigurationDirectory(), MathHelper.MODID + ".cfg"));
        MinecraftForge.EVENT_BUS.register(new EventConfigChange());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new ClickOverride());
        network.registerMessage(PacketActivateBlock.MSGAB.class, PacketActivateBlock.class, 0, Side.SERVER);
        //MinecraftForge.EVENT_BUS.register(new GuiOverrideEvent());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
