package dantetc.saoreborn.proxy;


import dantetc.saoreborn.blocks.ModBlocks;
import dantetc.saoreborn.items.ModItems;
import dantetc.saoreborn.oregen.OreGen;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
            ModItems.init();
            ModBlocks.init();
        GameRegistry.registerWorldGenerator(new OreGen(), 3);
        }

        public void init(FMLInitializationEvent e) {
        }

        public void postInit(FMLPostInitializationEvent e) {
        }
    public void registerItemRenderer(Item item, int meta, String id) {
    }
}
