package dantetc.saoreborn.proxy;

import dantetc.saoreborn.Saoreborn;
import dantetc.saoreborn.items.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
        public void preInit(FMLPreInitializationEvent e) {
            ModItems.init();
        }

        public void init(FMLInitializationEvent e) {

        }

        public void postInit(FMLPostInitializationEvent e) {

        }
    public void registerItemRenderer(Item item, int meta, String id) {
    }
}
