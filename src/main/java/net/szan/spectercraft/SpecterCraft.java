package net.szan.spectercraft;

import net.fabricmc.api.ModInitializer;

import net.szan.spectercraft.block.ModBlocks;
import net.szan.spectercraft.item.ModItemGroups;
import net.szan.spectercraft.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpecterCraft implements ModInitializer {

	public static final String MOD_ID = "spectercraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LOGGER.info("Hello SpecterCraft!");
	}
}
