package net.szan.spectercraft.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class ModEntityRenderers {
    public static void register(){
        EntityRendererRegistry.register(ModEntities.SPECTER_PROJECTILE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.BLOOD_PROJECTILE, FlyingItemEntityRenderer::new);
    }
}
