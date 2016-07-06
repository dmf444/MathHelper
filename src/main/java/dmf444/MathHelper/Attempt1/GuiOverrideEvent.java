package dmf444.MathHelper.Attempt1;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by TeamDMFMM on 6/28/2016. Code originally written
 * for MathHelper. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class GuiOverrideEvent {

    @SubscribeEvent
    public void overrideGUI(GuiOpenEvent event){
        if(event.getGui() instanceof GuiFiller){
            event.setGui(((GuiFiller)event.getGui()).getGui());
        }else
        if(event.getGui() instanceof GuiContainer && !(event.getGui() instanceof InventoryEffectRenderer)) {
            event.setGui(new GuiMath(event.getGui()));
        }
    }
}
