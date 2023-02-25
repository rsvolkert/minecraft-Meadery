package net.rvolkert.meadery.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rvolkert.meadery.Meadery;
import net.rvolkert.meadery.item.mead.MeadItem;
import net.rvolkert.meadery.item.mead.MeadProperties;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Meadery.MOD_ID);
    public static final RegistryObject<Item> EMPTY_MEAD_BOTTLE = ITEMS.register("mead_bottle_empty",
            () -> new MeadItem(new Item.Properties()));

    public static final RegistryObject<Item> DRY_MEAD = ITEMS.register("dry_mead",
            () -> new MeadItem(new Item.Properties().food(MeadProperties.DRY_MEAD).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
