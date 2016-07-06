package dmf444.MathHelper.Attempt2;

import dmf444.MathHelper.MathHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;


public class ClickOverride {

    private ArrayList<Block> hackBlock = new ArrayList<Block>();

    public ClickOverride(){
        hackBlock.add(Blocks.CHEST);
        hackBlock.add(Blocks.TRAPPED_CHEST);
        hackBlock.add(Blocks.DISPENSER);
        hackBlock.add(Blocks.DROPPER);
        hackBlock.add(Blocks.FURNACE);
        hackBlock.add(Blocks.ENCHANTING_TABLE);
        hackBlock.add(Blocks.BREWING_STAND);
        hackBlock.add(Blocks.ANVIL);
        hackBlock.add(Blocks.BEACON);
        hackBlock.add(Blocks.CRAFTING_TABLE);
        hackBlock.add(Blocks.HOPPER);
    }

    @SubscribeEvent
    public void overrideEvent(PlayerInteractEvent.RightClickBlock event){
        if(shouldOverride(event.getWorld().getBlockState(event.getPos()).getBlock())){
            event.setCanceled(true);
            event.getEntityPlayer().openGui(MathHelper.instance, 0, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
        }
    }

    private boolean shouldOverride(Block block){
        for(Block test : hackBlock){
            if(block.equals(test)){
                return true;
            }
        }
        return false;
    }
}
