package net.szan.spectercraft.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.szan.spectercraft.item.ModItems;

public class SoulItem extends Item {

    public SoulItem() {
        super(new Item.Settings());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack soulStack = player.getStackInHand(hand);
        ItemStack offhand = player.getOffHandStack();

        // 🔹 Obsługa Specter Staff
        if (offhand.isOf(ModItems.SPECTER_STAFF) && offhand.getItem() instanceof SpecterStaffItem staffItem) {
            int currentDurability = offhand.getOrCreateNbt().getInt("SpecterStaffDurability");

            if (currentDurability >= SpecterStaffItem.MAX_DURABILITY) {
                if (world.isClient()) {
                    player.sendMessage(Text.literal("Specter Staff is fully charged!"), true);
                }
                return TypedActionResult.fail(soulStack);
            }

            staffItem.recharge(offhand, 1);
            soulStack.decrement(1);
            return TypedActionResult.success(soulStack, world.isClient());
        }

        // 🔹 Obsługa Blood Staff
        if (offhand.isOf(ModItems.BLOOD_STAFF) && offhand.getItem() instanceof BloodStaffItem bloodStaff) {
            NbtCompound nbt = offhand.getOrCreateNbt();
            int currentDurability = nbt.getInt("BloodStaffDurability");

            if (currentDurability >= BloodStaffItem.MAX_DURABILITY) {
                if (world.isClient()) {
                    player.sendMessage(Text.literal("Blood Staff is fully charged!"), true);
                }
                return TypedActionResult.fail(soulStack);
            }

            bloodStaff.recharge(offhand, 1);
            soulStack.decrement(1);
            return TypedActionResult.success(soulStack, world.isClient());
        }

        return TypedActionResult.pass(soulStack);
    }
}