package dantetc.saoreborn.items.potions;

import dantetc.saoreborn.Saoreborn;
import dantetc.saoreborn.items.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;



public class ItemPotions extends ItemFood implements ItemModelProvider {
    private String name;
    public ItemPotions(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);
        setCreativeTab(CreativeTabs.BREWING);
        setMaxStackSize(64);
        amount = 0;
        saturation = 0;
        isWolfFood = true;
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
    }

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }
    @Override
    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH,3));
        }
    }
    @Override
    public void registerItemModel(Item item) {
        Saoreborn.proxy.registerItemRenderer(this, 0, name);
    }
}
