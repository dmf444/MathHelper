package dmf444.MathHelper.Attempt2;


import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
    public static Configuration config;

    //ALL CONFIGS MUST BE PROTECTED!!!
    protected static int percentageChange;
    protected static int foodPrecentage;
    protected static boolean additionSubtraction;
    protected static boolean multiplicationDivision;

    public static void init(File configFile){
        if(config == null){
            config = new Configuration(configFile);
            loadConfig();
        }

    }

    public static void loadConfig(){
        //Put config here
        percentageChange = config.get("Mathhelper", "percentchance", 100, "Chance for the mod to ask a math question, must be between 0 and 100").getInt(100);
        additionSubtraction = config.get("Mathhelper", "AdditionSubtraction", true, "Ask Addition and Subtraction Questions").getBoolean(true);
        multiplicationDivision = config.get("Mathhelper", "MultiplicationDivision", true, "Ask Division and Multiplication Questions").getBoolean(true);

        if(config.hasChanged()){
            config.save();
        }
    }
}

