package dantetc.saoreborn;

import dantetc.saoreborn.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = Saoreborn.MOD_ID,
        name = Saoreborn.MOD_NAME,
        version = Saoreborn.VERSION
)
public class Saoreborn {

    public static final String MOD_ID = "saoreborn";
    public static final String MOD_NAME = "Sao Reborn";
    public static final String VERSION = "1.0";
    public static final Item.ToolMaterial adminToolMaterial = EnumHelper.addToolMaterial("ADMIN", 5, 1000000000, 10, 125, 100);

    @SidedProxy(clientSide = "dantetc.saoreborn.proxy.ClientProxy", serverSide = "dantetc.saoreborn.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Saoreborn instance;

    public static org.apache.logging.log4j.Logger logger;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
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
