package dantetc.saoreborn.items.swords;

import dantetc.saoreborn.Saoreborn;
import dantetc.saoreborn.items.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;


public class ItemSwords extends ItemSword implements ItemModelProvider{
    private String name;

    public ItemSwords(ToolMaterial material, boolean EnchantmentFireAspect, boolean EnchantmentLootBonus,String name) {
        super(material);
        EnchantmentFireAspect = true;
        setCreativeTab(CreativeTabs.COMBAT);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
    }

    @Override
    public void registerItemModel(Item item) {
        Saoreborn.proxy.registerItemRenderer(this, 0, name);
    }
}
