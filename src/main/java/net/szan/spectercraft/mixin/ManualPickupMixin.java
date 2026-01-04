package net.szan.spectercraft.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class ManualPickupMixin {
    @Inject(method = "doItemUse", at = @At("HEAD"))
    private void onRightClick(CallbackInfoReturnable<ActionResult> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        
        if (client.crosshairTarget != null && client.crosshairTarget.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityHit = (EntityHitResult) client.crosshairTarget;
            
            if (entityHit.getEntity() instanceof ItemEntity itemEntity && client.player != null) {
                PlayerInventory inventory = client.player.getInventory();
                int selectedSlot = inventory.selectedSlot;
                ItemStack handStack = inventory.getStack(selectedSlot);
                
                if (handStack.isEmpty()) {
                    ItemStack itemStack = itemEntity.getStack();
                    inventory.setStack(selectedSlot, itemStack.copy());
                    itemEntity.discard();
                }
            }
        }
    }
}
