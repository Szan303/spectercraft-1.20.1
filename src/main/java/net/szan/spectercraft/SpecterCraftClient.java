package net.szan.spectercraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.szan.spectercraft.block.ModBlocks;
import net.szan.spectercraft.entity.ModEntities;

public class SpecterCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACID, RenderLayer.getTranslucent());
        EntityRendererRegistry.register(ModEntities.SPECTER_PROJECTILE, FlyingItemEntityRenderer::new);

    }
}
