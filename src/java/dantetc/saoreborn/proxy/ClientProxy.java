package dantetc.saoreborn.proxy;

import dantetc.saoreborn.Saoreborn;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by xavier on 11/2/2016.
 */
public class ClientProxy extends CommonProxy{
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Saoreborn.MOD_ID + ":" + id, "inventory"));
    }
}
