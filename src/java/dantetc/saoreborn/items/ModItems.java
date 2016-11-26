package dantetc.saoreborn.items;

import dantetc.saoreborn.Saoreborn;
import dantetc.saoreborn.items.potions.ItemPotions;
import dantetc.saoreborn.items.swords.ItemSwords;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static ItemPotions health;
    public static ItemSwords adminsword;
    public static void init(){
        health = register(new ItemPotions( 0, 0.0f, true, "healthpot"));
        adminsword = register(new ItemSwords(Saoreborn.adminToolMaterial,false,true,"adminsword"));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider)item).registerItemModel(item);
        }

        return item;
    }

}
