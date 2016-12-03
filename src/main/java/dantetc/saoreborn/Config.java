package dantetc.saoreborn;

import dantetc.saoreborn.blocks.Repairer;
import dantetc.saoreborn.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;

import javax.annotation.Nullable;

public class Config {

    private static final String CATEGORY_GENERAL = "general options";

    public static boolean repair;


    public static void readConfig(FMLPreInitializationEvent preEvent) {
        SaoReborn.config = new Configuration(preEvent.getSuggestedConfigurationFile());
        SaoReborn.config.load();

        repair = SaoReborn.config.getBoolean("Repair", CATEGORY_GENERAL, true, "True if have repair, false if not have");
        SaoReborn.config.save();
        Config.save();
    }

    private static void save() {
        if (SaoReborn.config.hasChanged()) {
            SaoReborn.config.save();
        }
    }
    public String[] defaultValue;

    public String[] getValue(){
        return this.defaultValue;
    }
}