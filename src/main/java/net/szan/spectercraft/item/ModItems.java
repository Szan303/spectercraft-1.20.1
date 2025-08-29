package net.szan.spectercraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.szan.spectercraft.SpecterCraft;
import net.minecraft.util.Identifier;
import net.szan.spectercraft.item.custom.*;

public class ModItems {
    // jak chcesz dodać kolejny item skopiuj tą klase pod tą wiadomością
    public static final Item SOUL = registerItem("soul", new SoulItem());
    public static final Item SPECTER_INGOT = registerItem("specter_ingot", new Item(new FabricItemSettings()));
    public static final Item ENERGY_ORB = registerItem("energy_orb", new Item(new FabricItemSettings()));
    public static final Item SPECTER_STAFF = registerItem("specter_staff", new SpecterStaffItem());
    public static final Item SPECTER_AXE = registerItem("specter_axe", new SpecterAxeItem());
    public static final Item SPECTER_PICKAXE = registerItem("specter_pickaxe", new SpecterPickaxeItem());
    public static final Item SPECTER_SHOVEL = registerItem("specter_shovel", new SpecterShovelItem());
    public static final Item COMPRESSED_SOUL = registerItem("compressed_soul", new Item(new FabricItemSettings()));
    public static final Item ORB = registerItem("orb", new Item(new FabricItemSettings()));
    public static final Item ENERGY_STAFF = registerItem("energy_staff", new Item(new FabricItemSettings()));
    public static final Item BLOOD_STAFF = registerItem("blood_staff", new BloodStaffItem());
    public static final Item STAFF_HANDLE = registerItem("staff_handle", new Item(new FabricItemSettings()));
    public static final Item SPECTER_PROJECTILE_ITEM = registerItem("specter_projectile_item", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item BLOOD_PROJECTILE_ITEM = registerItem("blood_projectile_item", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item BLOOD_ORB = registerItem("blood_orb", new Item(new FabricItemSettings()));
    public static final Item SPECTER_SCYTHE = registerItem("specter_scythe", new SpecterScytheItem());
    // ===================================================================================
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
//        entries.add(SOUL);
//        entries.add(SPECTER_INGOT);
//        entries.add(ENERGY_ORB);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(SpecterCraft.MOD_ID, name), item);
    }

    public static void registerModItems(){
        SpecterCraft.LOGGER.info("Registering Mod Items" + SpecterCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}