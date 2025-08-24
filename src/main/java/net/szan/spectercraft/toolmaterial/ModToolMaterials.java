package net.szan.spectercraft.toolmaterial;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.szan.spectercraft.item.ModItems;

public class ModToolMaterials {
    public static final ToolMaterial SPECTER = new ToolMaterial() {
        @Override
        public int getDurability() {
            return 1800;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 9.0F;
        }

        @Override
        public float getAttackDamage() {
            return 3.5F;
        }

        @Override
        public int getMiningLevel() {
            return 5;
        }

        @Override
        public int getEnchantability() {
            return 12;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.SPECTER_INGOT);
        }
    };
}
