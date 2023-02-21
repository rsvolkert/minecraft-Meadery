package net.rvolkert.meadery.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rvolkert.meadery.Meadery;
import net.rvolkert.meadery.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Meadery.MOD_ID);

    public static final RegistryObject<BlockEntityType<FermentationBucketBlockEntity>> FERMENTATION_BUCKET =
            BLOCK_ENTITIES.register("fermentation_bucket", () ->
                    BlockEntityType.Builder.of(FermentationBucketBlockEntity::new,
                            ModBlocks.FERMENTATION_BUCKET.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
