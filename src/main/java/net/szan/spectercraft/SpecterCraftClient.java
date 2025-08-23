package net.szan.spectercraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import net.minecraft.client.render.RenderLayer;
import net.szan.spectercraft.block.ModBlocks;

public class SpecterCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACID, RenderLayer.getTranslucent());
    }
}
