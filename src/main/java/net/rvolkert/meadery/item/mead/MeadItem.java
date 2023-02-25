package net.rvolkert.meadery.item.mead;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.rvolkert.meadery.item.ModItems;

public class MeadItem extends Item {
    public int useDuration = 32;

    public MeadItem(Properties pProperties) {
        super(pProperties);
    }

    public void setUseDuration(int useDuration) {
        this.useDuration = useDuration;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return useDuration;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (pLivingEntity instanceof Player player) {
            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.EMPTY_MEAD_BOTTLE.get()));
            } else if (!player.getInventory().add(new ItemStack(ModItems.EMPTY_MEAD_BOTTLE.get()))) {
                player.drop(new ItemStack(ModItems.EMPTY_MEAD_BOTTLE.get()), false);
            }
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
