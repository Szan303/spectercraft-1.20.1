package net.szan.spectercraft.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.szan.spectercraft.entity.custom.BloodProjectileEntity;
import net.szan.spectercraft.item.ModItems;

import java.util.List;

public class BloodStaffItem extends Item {

    public static final int MAX_DURABILITY = 8;

    public BloodStaffItem() {
        super(new Item.Settings().maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        NbtCompound nbt = stack.getOrCreateNbt();

        // Inicjalizacja wytrzymałości jeśli brak
        if (!nbt.contains("BloodStaffDurability")) {
            nbt.putInt("BloodStaffDurability", MAX_DURABILITY);
        }

        int durability = nbt.getInt("BloodStaffDurability");

        if (durability <= 0) {
            if (world.isClient) {
                user.sendMessage(Text.literal("Staff needs to be recharged!"), true);
            }
            return TypedActionResult.fail(stack);
        }

        if (!world.isClient) {
            BloodProjectileEntity projectile = new BloodProjectileEntity(world, user);
            projectile.setItem(new ItemStack(ModItems.BLOOD_PROJECTILE_ITEM));
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(projectile);
        }

        // Zużycie 1 punktu wytrzymałości
        nbt.putInt("BloodStaffDurability", durability - 1);
        user.getItemCooldownManager().set(this, 20);

        return TypedActionResult.success(stack, world.isClient());
    }

    // Pasek wytrzymałości
    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getItemBarStep(ItemStack stack) {
        int durability = stack.getOrCreateNbt().getInt("BloodStaffDurability");
        durability = Math.max(0, Math.min(durability, MAX_DURABILITY)); // ograniczenie zakresu
        return Math.round(13.0F * durability / MAX_DURABILITY);
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return 0xAA00FF; // Fioletowy
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        NbtCompound nbt = stack.getOrCreateNbt();
        if (!nbt.contains("BloodStaffDurability")) {
            nbt.putInt("BloodStaffDurability", MAX_DURABILITY);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    // Metoda do ładowania
    public void recharge(ItemStack stack, int amount) {
        NbtCompound nbt = stack.getOrCreateNbt();
        int durability = nbt.getInt("BloodStaffDurability");
        nbt.putInt("BloodStaffDurability", Math.min(durability + amount, MAX_DURABILITY));
    }
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        int durability = stack.getOrCreateNbt().getInt("BloodStaffDurability"); // pobiera aktualny poziom
        tooltip.add(Text.literal("Energy: " + durability + " / " + MAX_DURABILITY).formatted(Formatting.AQUA)); // dodaje tekst do tooltipa
    }
}