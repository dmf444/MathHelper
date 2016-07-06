package dmf444.MathHelper.Attempt2;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


public class PacketActivateBlock implements IMessage {

    public PacketActivateBlock(){

    }

    public PacketActivateBlock(BlockPos poe){
        this.pos = poe;
    }

    private BlockPos pos;

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(ByteBufUtils.readTag(buf).getLong("POS"));
    }

    @Override
    public void toBytes(ByteBuf buf) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setLong("POS", pos.toLong());
        ByteBufUtils.writeTag(buf, tag);
    }

    public static class MSGAB implements IMessageHandler<PacketActivateBlock, IMessage>{

        @Override
        public IMessage onMessage(PacketActivateBlock message, MessageContext ctx) {
            EntityPlayer playah = ctx.getServerHandler().playerEntity;
            if(playah.getEntityWorld().getTileEntity(message.pos) != null) {
                if (playah.getEntityWorld().getTileEntity(message.pos) instanceof IInventory) {
                    ctx.getServerHandler().playerEntity.displayGUIChest(((IInventory)playah.getEntityWorld().getTileEntity(message.pos)));
                }
            }
            return null;
        }
    }
}
