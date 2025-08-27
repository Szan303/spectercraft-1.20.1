package net.szan.spectercraft.item.custom;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ShovelItem;
import net.szan.spectercraft.toolmaterial.ModToolMaterials;

public class EctoHoeItem extends HoeItem {

    public EctoHoeItem() {
        super(
                ModToolMaterials.ECTOPLASMA, // nasz custom material
                1,                        // attackDamage
                -3.0F,                    // attackSpeed
                new Settings()        // minimalne ustawienia, group można pominąć
        );
    }
}
//POPRAWIĆ WARTOŚCI