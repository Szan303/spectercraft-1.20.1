package net.szan.spectercraft.item.custom;

import net.minecraft.item.SwordItem;
import net.szan.spectercraft.toolmaterial.ModToolMaterials;

public class EchoScytheItem extends SwordItem {

    public EchoScytheItem() {
        super(
                ModToolMaterials.ECTOPLASMA, // nasz custom material
                5,                        // attackDamage
                -1.7F,                    // attackSpeed
                new Settings()        // minimalne ustawienia, group można pominąć
        );
    }
}
//POPRAWIĆ WARTOŚCI