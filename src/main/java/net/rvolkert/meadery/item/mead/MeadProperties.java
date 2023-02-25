package net.rvolkert.meadery.item.mead;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class MeadProperties {
    public static final FoodProperties DRY_MEAD = new FoodProperties.Builder()
            .alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 1.0f)
            .build();
}
