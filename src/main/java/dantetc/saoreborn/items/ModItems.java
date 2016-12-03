package dantetc.saoreborn.items;

import dantetc.saoreborn.SaoReborn;
import dantetc.saoreborn.items.potions.DamagePot;
import dantetc.saoreborn.items.potions.HealthPot;
import dantetc.saoreborn.items.swords.ItemSwords;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static ItemFoods lol;
    public static DamagePot posion;
    public static HealthPot health;
    public static ItemSwords adminsword;
    public static ItemSwords elcsword;
    public static void init(){
        lol = register(new ItemFoods(5, 10, true));
        posion = register(new DamagePot( 0, 0.0f, true));
        health = register(new HealthPot( 0, 0.0f, true));
        elcsword = register(new ItemSwords(SaoReborn.ElucidatorMaterial,true,true,"elucidatorsword"));
        adminsword = register(new ItemSwords(SaoReborn.adminToolMaterial,false,true,"adminsword"));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider)item).registerItemModel(item);
        }

        return item;
    }

}
