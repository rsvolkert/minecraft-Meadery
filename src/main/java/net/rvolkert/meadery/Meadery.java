package net.rvolkert.meadery;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.rvolkert.meadery.block.ModBlocks;
import net.rvolkert.meadery.item.ModCreativeModeTab;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rvolkert.meadery.item.ModItems;
import org.slf4j.Logger;

@Mod(Meadery.MOD_ID)
public class Meadery {
    public static final String MOD_ID = "meadery";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Meadery() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);
//        ModBlockEntities.register(modEventBus);
//
//        ModRecipes.register(modEventBus);
//        ModMenuTypes.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CLOVER_BLOSSOM.getId(), ModBlocks.POTTED_CLOVER);
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTab.MEADERY_TAB) {
            event.accept(ModItems.EMPTY_MEAD_BOTTLE);
            event.accept(ModItems.DRY_MEAD);
            event.accept(ModBlocks.CLOVER_BLOSSOM);
        }

        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.DRY_MEAD);
        }

        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.EMPTY_MEAD_BOTTLE);
        }

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.CLOVER_BLOSSOM);
        }
    }

    @Mod.EventBusSubscriber(modid = Meadery.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
