package net.szan.spectercraft.item.custom;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Item;
import net.szan.spectercraft.toolmaterial.ModToolMaterials;

public class SpecterPickaxeItem extends PickaxeItem {

    public SpecterPickaxeItem() {
        super(
                ModToolMaterials.SPECTER, // nasz custom material
                1,                        // attackDamage
                -2.8F,                    // attackSpeed
                new Item.Settings()        // minimalne ustawienia, group można pominąć
        );
    }
}
