package net.szan.spectercraft.item.custom;

import net.minecraft.item.PickaxeItem;
import net.szan.spectercraft.toolmaterial.ModToolMaterials;

public class EctoPickaxeItem extends PickaxeItem {

    public EctoPickaxeItem() {
        super(
                ModToolMaterials.ECTOPLASMA, // nasz custom material
                1,                        // attackDamage
                -2.8F,                    // attackSpeed
                new Settings()        // minimalne ustawienia, group można pominąć
        );
    }
}
//POPRAWIĆ WARTOŚCI
