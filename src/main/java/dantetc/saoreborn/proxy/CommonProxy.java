package dantetc.saoreborn.proxy;


import dantetc.saoreborn.blocks.ModBlocks;
import dantetc.saoreborn.items.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
            ModItems.init();
            ModBlocks.init();
        }

        public void init(FMLInitializationEvent e) {
        }

        public void postInit(FMLPostInitializationEvent e) {
        }
    public void registerItemRenderer(Item item, int meta, String id) {
    }
}