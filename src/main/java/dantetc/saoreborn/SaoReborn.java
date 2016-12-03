package dantetc.saoreborn;

import dantetc.saoreborn.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(
        modid = SaoReborn.MOD_ID,
        name = SaoReborn.MOD_NAME,
        version = SaoReborn.VERSION
)
public class SaoReborn {
    public static Configuration config;
    public static final String MOD_ID = "saoreborn";
    public static final String MOD_NAME = "Sao Reborn";
    public static final String VERSION = "1.0";
    public static final Item.ToolMaterial ElucidatorMaterial = EnumHelper.addToolMaterial("ELU", 5, 1000000000, 10, 250, 100);
    public static final Item.ToolMaterial adminToolMaterial = EnumHelper.addToolMaterial("ADMIN", 5, 1000000000, 10, 2500, 100);

    @SidedProxy(clientSide = "dantetc.saoreborn.proxy.ClientProxy", serverSide = "dantetc.saoreborn.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static SaoReborn instance;

    public static org.apache.logging.log4j.Logger logger;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "saoreborn.cfg"));
        logger = e.getModLog();
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

}
