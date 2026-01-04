package net.szan.spectercraft.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ScreenHandler.class)
public abstract class BlockInventorySlotsMixin {
    
    @Shadow public abstract List<Slot> getSlots();
    
    @Inject(method = "onSlotClick", at = @At("HEAD"), cancellable = true)
    private void blockSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player, CallbackInfo ci) {
        List<Slot> slots = this.getSlots();
        
        if (slotIndex >= 0 && slotIndex < slots.size()) {
            Slot slot = slots.get(slotIndex);
            
            if (slot.inventory instanceof PlayerInventory) {
                int index = slot.getIndex();
                if (index >= 9 && index <= 35) {
                    ci.cancel();
                }
            }
        }
    }
}
