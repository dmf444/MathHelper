package dmf444.MathHelper.Attempt1;

import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by TeamDMFMM on 6/28/2016. Code originally written
 * for MathHelper. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class ContainerOverrideEvent {

    @SubscribeEvent
    public void overrideContainer(PlayerContainerEvent.Open event){
        if(event.getContainer() instanceof ContainerFiller){
            event.getEntityPlayer().openContainer = ((ContainerFiller)event.getContainer()).getContainer();
        }else {
            event.getEntityPlayer().openContainer = new ContainerHold(event.getContainer());
        }
    }
}
