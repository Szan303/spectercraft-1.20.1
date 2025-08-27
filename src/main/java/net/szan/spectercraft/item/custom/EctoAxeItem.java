package net.szan.spectercraft.item.custom;

import net.minecraft.item.AxeItem;
import net.szan.spectercraft.toolmaterial.ModToolMaterials;

public class EctoAxeItem extends AxeItem {

    public EctoAxeItem() {
        super(
                ModToolMaterials.ECTOPLASMA, // nasz custom material
                6,                        // attackDamage
                -3.1F,                    // attackSpeed
                new Settings()        // minimalne ustawienia, group można pominąć
        );
    }
}
//POPRAWIĆ WARTOŚCI