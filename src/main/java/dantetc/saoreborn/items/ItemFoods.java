package dantetc.saoreborn.items;

import dantetc.saoreborn.SaoReborn;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemFoods extends ItemFood implements ItemModelProvider{

    public ItemFoods(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setUnlocalizedName("food");
        setRegistryName("food");
        setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return stack.getMetadata() > 0;
    }

    public EnumRarity getRarity(ItemStack stack)
    {
        return stack.getMetadata() == 0 ?EnumRarity.RARE : EnumRarity.EPIC;
    }
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {
            if (stack.getMetadata() > 0)
            {
                player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 400, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
                player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 6000, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2400, 3));
            }
            else
            {
                player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 1000, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 2400, 0));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        subItems.add(new ItemStack(itemIn));
        subItems.add(new ItemStack(itemIn, 1, 1));
        subItems.add(new ItemStack(itemIn, 1, 2));
    }

    @Override
    public void registerItemModel(Item item) {
        SaoReborn.proxy.registerItemRenderer(this, 0, "food");
    }
}
