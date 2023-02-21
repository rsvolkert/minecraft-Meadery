package net.rvolkert.meadery;

import net.rvolkert.meadery.block.ModBlocks;
import net.rvolkert.meadery.block.entity.ModBlockEntities;
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
        ModBlockEntities.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTab.MEADERY_TAB) {

        }
    }
}
