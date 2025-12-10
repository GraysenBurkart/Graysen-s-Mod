package net.gray.examplemod.entity;

import net.gray.examplemod.ExampleMod;
import net.gray.examplemod.entity.custom.MagicPigEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExampleMod.MODID);

    public static final RegistryObject<EntityType<MagicPigEntity>> MAGIC_PIG = ENTITY_TYPES.register("magic_pig",
            () -> EntityType.Builder.of(MagicPigEntity::new, MobCategory.CREATURE)
                    .sized(1.1f,1.1f).build("magic_pig"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
