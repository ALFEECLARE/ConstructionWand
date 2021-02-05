package thetadev.constructionwand.job;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thetadev.constructionwand.basics.WandUtil;

public class DestroySnapshot implements ISnapshot
{
    public final BlockState block;
    public final BlockPos pos;

    public DestroySnapshot(BlockState block, BlockPos pos) {
        this.pos = pos;
        this.block = block;
    }

    @Override
    public BlockPos getPos() {
        return pos;
    }

    @Override
    public BlockState getBlockState() {
        return block;
    }

    @Override
    public ItemStack getRequiredItems() {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean execute(World world, PlayerEntity player) {
        return WandUtil.removeBlock(world, player, block, pos);
    }

    @Override
    public boolean restore(World world, PlayerEntity player) {
        return WandUtil.placeBlock(world, player, block, pos, null);
    }

    @Override
    public void forceRestore(World world) {
        world.setBlockState(pos, block);
    }
}