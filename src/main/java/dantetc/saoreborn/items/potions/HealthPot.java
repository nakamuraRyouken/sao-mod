package dantetc.saoreborn.items.potions;

import dantetc.saoreborn.SaoReborn;
import dantetc.saoreborn.items.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;



public class HealthPot extends ItemFood implements ItemModelProvider {
    public HealthPot(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setCreativeTab(CreativeTabs.BREWING);
        setMaxStackSize(64);
        setAlwaysEdible();
        setRegistryName("healthpot");
        setUnlocalizedName("healthpot");
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
        SaoReborn.proxy.registerItemRenderer(this, 0, "healthpot");
    }
}
