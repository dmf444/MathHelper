package dmf444.MathHelper.Attempt1;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by TeamDMFMM on 6/28/2016. Code originally written
 * for MathHelper. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class ContainerFiller extends Container{

    public static Container storedcontainer;

    public ContainerFiller(Container container){
        this.storedcontainer = container;
    }


    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return false;
    }

    public static Container getContainer(){
        return storedcontainer;
    }
}
