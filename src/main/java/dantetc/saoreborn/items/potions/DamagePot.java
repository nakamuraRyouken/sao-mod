package dantetc.saoreborn.items.potions;

import dantetc.saoreborn.SaoReborn;
import dantetc.saoreborn.items.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class DamagePot extends ItemFood implements ItemModelProvider{
    public DamagePot(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.BREWING);
        setAlwaysEdible();
        setRegistryName("damagepot");
        setUnlocalizedName("damagepot");
    }

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }
    @Override
    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA,3));
            player.addPotionEffect(new PotionEffect(MobEffects.POISON,1));
        }
    }
    @Override
    public void registerItemModel(Item item) {
        SaoReborn.proxy.registerItemRenderer(this, 0, "damagepot");
    }

}
