package dantetc.saoreborn.blocks;

import dantetc.saoreborn.SaoReborn;
import dantetc.saoreborn.items.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class Repairer extends Block implements ItemModelProvider {

    public Repairer(Material material) {
        super(material);
        setCreativeTab(CreativeTabs.DECORATIONS);
        setUnlocalizedName("repairer");
        setRegistryName("repairer");
        setHardness(3.0f);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            ItemStack item = player.getHeldItem(hand);
            if (item != null /*&& canBeRepaired(item)*/) {
                if (item.getItemDamage() <= 0) {
                    player.addChatComponentMessage(new TextComponentString("Item is not broken."));
                    //EntityAnimal lol = new EntityCow(world);
                    //lol.setLocationAndAngles(pos.getX()+ 0.5,pos.getY()+1.5,pos.getZ()+0.5, 0, 0);
                    //world.spawnEntityInWorld(lol);
                } else {
                    player.addChatComponentMessage(new TextComponentString("Item is repaired."));
                    //EntityCow lol = new EntityCow(world);
                    //lol.setLocationAndAngles(pos.getX()+ 0.5,pos.getY()+1.5,pos.getZ()+0.5, 0, 0);
                    //world.spawnEntityInWorld(lol);
                    item.setItemDamage(0);
                }
            }
        }
        return super.onBlockActivated(world, pos, state, player, hand, heldItem, side, hitX, hitY, hitZ);
    }

    @Override
    public void registerItemModel(Item itemBlock) {
        SaoReborn.proxy.registerItemRenderer(itemBlock, 0, "repairer");
    }

}
