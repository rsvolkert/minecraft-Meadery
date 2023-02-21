package net.rvolkert.meadery.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.rvolkert.meadery.block.entity.FermentationBucketBlockEntity;
import org.jetbrains.annotations.Nullable;

public class FermentationBucketBlock extends BaseEntityBlock {
    public FermentationBucketBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new FermentationBucketBlockEntity(pPos, pState);
    }
}
