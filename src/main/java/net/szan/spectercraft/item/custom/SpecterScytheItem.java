package net.szan.spectercraft.item.custom;


import net.minecraft.item.SwordItem;
import net.szan.spectercraft.toolmaterial.ModToolMaterials;

public class SpecterScytheItem extends SwordItem {

        public SpecterScytheItem() {
            super(
                    ModToolMaterials.SPECTER, // nasz custom material
                    5,                        // attackDamage
                    -1.5F,                    // attackSpeed
                    new Settings()        // minimalne ustawienia, group można pominąć
            );
        }
}
