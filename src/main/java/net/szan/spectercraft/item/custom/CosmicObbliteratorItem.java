package net.szan.spectercraft.item.custom;

import net.minecraft.item.AxeItem;
import net.minecraft.item.SwordItem;
import net.szan.spectercraft.toolmaterial.ModToolMaterials;

public class CosmicObbliteratorItem extends SwordItem {

    public CosmicObbliteratorItem() {
        super(
                ModToolMaterials.ECTOPLASMA, // nasz custom material
                5,                        // attackDamage
                -1.7F,                    // attackSpeed
                new Settings()        // minimalne ustawienia, group można pominąć
        );
    }
}
//POPRAWIĆ WARTOŚCI