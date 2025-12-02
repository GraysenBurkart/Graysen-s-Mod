package net.gray.examplemod.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties DRAGON_FRUIT = new FoodProperties.Builder().nutrition(5).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,500), 0.15f).build();
}
