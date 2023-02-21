package net.rvolkert.meadery.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rvolkert.meadery.Meadery;

@Mod.EventBusSubscriber(modid = Meadery.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab MEADERY_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        MEADERY_TAB = event.registerCreativeModeTab(new ResourceLocation(Meadery.MOD_ID, "meadery_tab"),
                builder -> builder.icon(() -> new ItemStack(Items.HONEY_BOTTLE)).title(Component.literal("Meadery Tab")).build());
    }
}
