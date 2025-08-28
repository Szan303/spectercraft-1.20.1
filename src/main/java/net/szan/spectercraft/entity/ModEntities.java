package net.szan.spectercraft.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.szan.spectercraft.entity.custom.BloodProjectileEntity;
import net.szan.spectercraft.entity.custom.SpecterProjectileEntity;

public class ModEntities {
    public static final EntityType<SpecterProjectileEntity> SPECTER_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("spectercraft", "specter_projectile"),
            FabricEntityTypeBuilder.<SpecterProjectileEntity>create(SpawnGroup.MISC, SpecterProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(64)
                    .trackedUpdateRate(10)
                    .build()
    );


    public static final EntityType<BloodProjectileEntity> BLOOD_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("spectercraft", "blood_projectile"),
            FabricEntityTypeBuilder.<BloodProjectileEntity>create(SpawnGroup.MISC, BloodProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static void register() {}
}
