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
    public static final Item SOUL = registerItem("soul", new Item(new FabricItemSettings()));
    public static final Item SPECTER_INGOT = registerItem("specter_ingot", new Item(new FabricItemSettings()));
    public static final Item ENERGY_ORB = registerItem("energy_orb", new Item(new FabricItemSettings()));
    public static final Item SPECTER_STAFF = registerItem("specter_staff", new Item(new FabricItemSettings()));
    public static final Item SPECTER_AXE = registerItem("specter_axe", new SpecterAxeItem());
    public static final Item SPECTER_PICKAXE = registerItem("specter_pickaxe", new SpecterPickaxeItem());
    public static final Item SPECTER_SHOVEL = registerItem("specter_shovel", new SpecterShovelItem());
    public static final Item CHARGED_SOUL= registerItem("charged_soul", new Item(new FabricItemSettings()));
    public static final Item COMPRESSED_CHARGED_SOUL = registerItem("compressed_charged_soul", new Item(new FabricItemSettings()));
    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item ECTOPLASM = registerItem("ectoplasm", new Item(new FabricItemSettings()));
    public static final Item COSMIC_OBBLITERATOR = registerItem("cosmic_obbliterator", new CosmicObbliteratorItem());
    public static final Item ECTO_AXE = registerItem("ecto_axe", new EctoAxeItem());
    public static final Item ECTO_PICKAXE = registerItem("ecto_pickaxe", new EctoPickaxeItem());
    public static final Item ECTO_SHOVEL = registerItem("ecto_shovel", new EctoShovelItem());
    public static final Item ECTO_HOE = registerItem("ecto_hoe", new EctoHoeItem());
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