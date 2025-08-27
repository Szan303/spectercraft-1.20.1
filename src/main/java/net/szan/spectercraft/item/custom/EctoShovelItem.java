package net.szan.spectercraft.item.custom;

import net.minecraft.item.ShovelItem;
import net.szan.spectercraft.toolmaterial.ModToolMaterials;

public class EctoShovelItem extends ShovelItem {

    public EctoShovelItem() {
        super(
                ModToolMaterials.ECTOPLASMA, // nasz custom material
                0.5F,                        // attackDamage
                -3.0F,                    // attackSpeed
                new Settings()        // minimalne ustawienia, group można pominąć
        );
    }
}
//POPRAWIĆ WARTOŚCI