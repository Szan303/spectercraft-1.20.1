package net.szan.spectercraft.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.szan.spectercraft.toolmaterial.ModToolMaterials;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpecterShovelItem extends ShovelItem {

    public SpecterShovelItem() {
        super(
                ModToolMaterials.SPECTER, // nasz custom material
                0.5F,                        // attackDamage
                -3.0F,                    // attackSpeed
                new Settings()        // minimalne ustawienia, group można pominąć
        );
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.spectercraft.specter_shovel"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
