package dmf444.MathHelper.Attempt2;

import dmf444.MathHelper.Attempt1.GuiFiller;
import dmf444.MathHelper.MathHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.server.FMLServerHandler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.io.IOException;
import java.util.Random;


public class GuiMath extends GuiScreen{

    private static EntityPlayer playah;
    private static BlockPos poz;
    private GuiTextField textField;
    private GuiErrorMessage message;
    private int answer, firstNum, secondNum;
    private mathType type;
    protected int xSize = 176;
    protected int ySize = 166;

    public GuiMath(EntityPlayer player, BlockPos pos){
        this.playah = player;
        this.poz = pos;

    }

    public void initGui()
    {
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        Keyboard.enableRepeatEvents(true);
        this.buttonList.add(new GuiButton(0, x+40, y+120, 100, 20, I18n.format("msg.mathhelper.Submit")));
        message = new GuiErrorMessage(2, x+7, y+10, I18n.format("msg.mathhelper.WrongAnswer"));
        this.buttonList.add(message);
        message.visible = false;
        this.textField = new GuiTextField(1, this.fontRendererObj, x+50, y+95, 80, 20);
        this.textField.setFocused(true);
        this.textField.setMaxStringLength(4);

        Random rand = new Random();

        if(ConfigHandler.additionSubtraction && !ConfigHandler.multiplicationDivision) {
            if(rand.nextInt(2) == 1) {
                firstNum = rand.nextInt(99 - 0) + 0;
                secondNum = playah.getEntityWorld().rand.nextInt(99);
                answer = firstNum + secondNum;
                type = mathType.ADDITION;
            }else{
                firstNum = rand.nextInt(99 - 0) + 0;
                secondNum = playah.getEntityWorld().rand.nextInt(99);
                if(firstNum > secondNum) {
                    answer = firstNum - secondNum;
                    type = mathType.SUBTRACTION_TYPE1;
                }else{
                    answer = secondNum - firstNum;
                    type = mathType.SUBTRACTION_TYPE2;
                }

            }
        }else
        if(ConfigHandler.multiplicationDivision && !ConfigHandler.additionSubtraction) {
            if(rand.nextInt(2) == 1) {
                firstNum = rand.nextInt(12);
                secondNum = playah.getEntityWorld().rand.nextInt(12);
                answer = firstNum * secondNum;
                type = mathType.MULTIPLICATION;
            }else{
                firstNum = rand.nextInt(12);
                secondNum = playah.getEntityWorld().rand.nextInt(12);
                int muliple = firstNum * secondNum;
                answer = firstNum;
                firstNum = muliple;
                type = mathType.DIVISION;

            }
        }else
        if(ConfigHandler.multiplicationDivision && ConfigHandler.additionSubtraction) {
            int nun = rand.nextInt(4);
            if(nun == 0) {
                firstNum = rand.nextInt(99 - 0) + 0;
                secondNum = playah.getEntityWorld().rand.nextInt(99);
                answer = firstNum + secondNum;
                type = mathType.ADDITION;
            }else if(nun == 1) {
                firstNum = rand.nextInt(99 - 0) + 0;
                secondNum = playah.getEntityWorld().rand.nextInt(99);
                if (firstNum > secondNum) {
                    answer = firstNum - secondNum;
                    type = mathType.SUBTRACTION_TYPE1;
                } else {
                    answer = secondNum - firstNum;
                    type = mathType.SUBTRACTION_TYPE2;
                }
            }else if(nun == 2) {
                firstNum = rand.nextInt(12);
                secondNum = playah.getEntityWorld().rand.nextInt(12);
                answer = firstNum * secondNum;
                type = mathType.MULTIPLICATION;
            }else if(nun == 3){
                firstNum = rand.nextInt(12);
                secondNum = playah.getEntityWorld().rand.nextInt(12);
                int muliple = firstNum * secondNum;
                answer = firstNum;
                firstNum = muliple;
                type = mathType.DIVISION;
            }
        }
    }

    public void updateScreen()
    {
        this.textField.updateCursorCounter();
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawGUI();
        this.checkButton();
        this.textField.drawTextBox();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    float t = 0;
    private void checkButton() {
        if(message.visible){
            t++;
            if(t >= 200){
                message.visible = false;
                t = 0;
            }
        }
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if((keyCode >= 2 && keyCode <= 11) || (keyCode == 71 || keyCode == 72 || keyCode == 73 || keyCode ==75 || keyCode == 76 || keyCode == 77 || keyCode == 79 || keyCode == 80 || keyCode == 81 || keyCode == 82 || keyCode == 14)) {
            this.textField.textboxKeyTyped(typedChar, keyCode);
        }
        if(keyCode == 1){
            this.mc.displayGuiScreen((GuiScreen)null);
        }

    }
    private void drawGUI() {
        GL11.glPushMatrix();
        this.mc.renderEngine.bindTexture(new ResourceLocation("mathhelper", "textures/gui/blankGui.png"));
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        String equation = "";

        if(type == mathType.ADDITION){
            equation = firstNum + " + " + secondNum + " =";
        }else if(type == mathType.SUBTRACTION_TYPE1){
            equation = firstNum + " - " + secondNum + " =";
        }else if(type == mathType.SUBTRACTION_TYPE2){
            equation = secondNum + " - " + firstNum + " =";
        }else if(type == mathType.MULTIPLICATION){
            equation = firstNum + " x " + secondNum + " =";
        }else if(type == mathType.DIVISION){
            equation = firstNum + " ÷ " + secondNum + " =";
        }

        this.fontRendererObj.drawString(equation, x+40+(fontRendererObj.getStringWidth(equation)/2), y+50, 000000);

        GL11.glPopMatrix();
    }

    protected void actionPerformed(GuiButton button) throws IOException
    {
        if(button.id == 0){
            if(playah.getEntityWorld().getTileEntity(poz) != null) {
                if(playah.getEntityWorld().getTileEntity(poz) instanceof IInventory) {
                    if(!textField.getText().isEmpty()) {
                        if (answer == Integer.parseInt(textField.getText())) {
                            playah.displayGUIChest(((IInventory) playah.getEntityWorld().getTileEntity(poz)));
                            MathHelper.network.sendToServer(new PacketActivateBlock(poz));
                        } else {
                            message.visible = true;
                        }
                    }else {
                        message.visible = true;
                    }
                }
            }else{
              //MathHelper.network.sendToServer(new PacketActivateBlock(poz));
            }
        }
    }

    private static enum mathType{
        ADDITION,
        SUBTRACTION_TYPE1,
        SUBTRACTION_TYPE2,
        MULTIPLICATION,
        DIVISION;
    }

}
