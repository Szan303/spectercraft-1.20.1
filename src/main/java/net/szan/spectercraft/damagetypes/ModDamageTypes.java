package net.szan.spectercraft.damagetypes;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.util.Identifier;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> ACID = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            new Identifier("spectercraft", "acid"));
    public static final RegistryKey<DamageType> BLOOD_MAGIC = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            new Identifier("spectercraft", "blood_magic"));
    public static final RegistryKey<DamageType> SPECTER_MAGIC = RegistryKey.of(RegistryKeys.DAMAGE_TYPE,
            new Identifier("spectercraft", "specter_magic"));
}
