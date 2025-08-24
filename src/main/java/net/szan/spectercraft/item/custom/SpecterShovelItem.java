package net.szan.spectercraft.item.custom;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.szan.spectercraft.toolmaterial.ModToolMaterials;

public class SpecterShovelItem extends ShovelItem {

    public SpecterShovelItem() {
        super(
                ModToolMaterials.SPECTER, // nasz custom material
                0.5F,                        // attackDamage
                -3.0F,                    // attackSpeed
                new Settings()        // minimalne ustawienia, group można pominąć
        );
    }
}
