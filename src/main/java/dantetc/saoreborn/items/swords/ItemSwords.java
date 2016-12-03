package dantetc.saoreborn.items.swords;

import dantetc.saoreborn.SaoReborn;
import dantetc.saoreborn.items.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;


public class ItemSwords extends ItemSword implements ItemModelProvider{
    private String name;

    public ItemSwords(ToolMaterial material, boolean EnchantmentFireAspect, boolean EnchantmentLootBonus,String name) {
        super(material);
        setCreativeTab(CreativeTabs.COMBAT);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
    }

    @Override
    public void registerItemModel(Item item) {
        SaoReborn.proxy.registerItemRenderer(this, 0, name);
    }
}
