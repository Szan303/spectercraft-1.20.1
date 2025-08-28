package net.szan.spectercraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.szan.spectercraft.SpecterCraft;
import net.szan.spectercraft.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup SPECTER_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(SpecterCraft.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.specter"))
                    .icon(() -> new ItemStack(ModItems.ENERGY_ORB)).entries((displayContext, entries) -> {
                        //tutaj dawaj entries z ModItems żeby itemy były w grupie SpecterCraft Group!!!
                        entries.add(ModItems.SOUL);
                        entries.add(ModItems.SPECTER_INGOT);
                        entries.add(ModItems.ENERGY_ORB);
                        entries.add(ModItems.SPECTER_STAFF);
                        entries.add(ModItems.SPECTER_AXE);
                        entries.add(ModItems.SPECTER_PICKAXE);
                        entries.add(ModItems.SPECTER_SHOVEL);
                        entries.add(ModItems.COMPRESSED_SOUL);
                        entries.add(ModItems.ECTOPLASM);
                        entries.add(ModItems.ECTO_AXE);
                        entries.add(ModItems.ECTO_HOE);
                        entries.add(ModItems.ECTO_PICKAXE);
                        entries.add(ModItems.ECTO_SHOVEL);
                        entries.add(ModItems.ECHO_SCYTHE);
                        entries.add(ModItems.STAFF_HANDLE);
                        entries.add(ModItems.ENERGY_STAFF);
                        entries.add(ModItems.ORB);

                        entries.add(ModBlocks.ACID);
                        entries.add(ModBlocks.ERROR_BLOCK);
                        entries.add(ModBlocks.SPECTER_BLOCK);
                        entries.add(ModBlocks.SOUL_BRICKS);
                        entries.add(ModBlocks.CHISELED_SOUL_BRICKS);

                        entries.add(ModItems.TOMATO);
                    }).build());

    public static void registerItemGroups() {
        SpecterCraft.LOGGER.info("Registering Item Groups " + SpecterCraft.MOD_ID);
    }
}
