package net.szan.spectercraft.item.custom;

import net.minecraft.item.AxeItem;
import net.szan.spectercraft.toolmaterial.ModToolMaterials;

public class SpecterAxeItem extends AxeItem {

    public SpecterAxeItem() {
        super(
                ModToolMaterials.SPECTER, // nasz custom material
                5,                        // attackDamage
                -3.1F,                    // attackSpeed
                new Settings()        // minimalne ustawienia, group można pominąć
        );
    }
}
