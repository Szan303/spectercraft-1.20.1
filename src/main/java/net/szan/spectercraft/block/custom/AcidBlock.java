package net.szan.spectercraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.szan.spectercraft.SpecterCraft;
import net.szan.spectercraft.damagetypes.ModDamageTypes;

public class AcidBlock extends Block {

    private static final VoxelShape SHAPE = Block.createCuboidShape(1, 0, 1, 15, 15, 15);

    public AcidBlock(Settings settings) {
        super(settings);
    }
    //Miodowy Hitbox
    public VoxelShape getOutlineShape(BlockState state , BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);

        if (!world.isClient && entity instanceof LivingEntity living) {
//            living.damage(world.getDamageSources().magic(), 2.0F);
            DamageSource damageSource = new DamageSource(
                    world.getRegistryManager()
                            .get(RegistryKeys.DAMAGE_TYPE)
                            .entryOf(ModDamageTypes.ACID));
            entity.damage(damageSource, 2.0f);
        }
    }
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.handleFallDamage(fallDistance, 0.5F, entity.getDamageSources().fall());
    }

}
