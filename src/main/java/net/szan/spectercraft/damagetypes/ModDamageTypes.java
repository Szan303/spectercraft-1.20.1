package net.szan.spectercraft.damagetypes;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.util.Identifier;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> ACID = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            new Identifier("spectercraft", "acid"));
}
