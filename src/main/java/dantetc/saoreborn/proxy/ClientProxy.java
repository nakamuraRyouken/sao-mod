package dantetc.saoreborn.proxy;

import dantetc.saoreborn.SaoReborn;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


/**
 * Created by xavier on 11/2/2016.
 */
public class ClientProxy extends CommonProxy{

    @Override
    @SideOnly(Side.CLIENT)
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(SaoReborn.MOD_ID + ":" + id, "inventory"));
    }
}
