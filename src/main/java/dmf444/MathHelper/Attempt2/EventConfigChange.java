package dmf444.MathHelper.Attempt2;


import dmf444.MathHelper.MathHelper;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventConfigChange {

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e){
        if(e.getModID().equalsIgnoreCase(MathHelper.MODID)){
            ConfigHandler.loadConfig();
        }
    }

}