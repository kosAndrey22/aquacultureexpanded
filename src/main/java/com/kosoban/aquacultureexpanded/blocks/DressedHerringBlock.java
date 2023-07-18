package com.kosoban.aquacultureexpanded.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DressedHerringBlock extends Block {
    public static final int MAX_BITES = 6;
    public static final IntegerProperty BITES = BlockStateProperties.BITES;

    protected static final float AABB_OFFSET = 1.0F;
    protected static final float AABB_SIZE_PER_BITE = 2.0F;

    protected int NUTRITION = 2;
    protected float SATURATION_MOD = 0.7F;

    protected static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[]{
            Block.box(1.0D, 2.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(3.0D, 2.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(5.0D, 2.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(7.0D, 2.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(9.0D, 2.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(11.0D, 2.0D, 1.0D, 15.0D, 8.0D, 15.0D),
            Block.box(13.0D, 2.0D, 1.0D, 15.0D, 8.0D, 15.0D)
    };

    protected static final VoxelShape PLATE_SHAPE = Shapes.or(
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D),
            Block.box(0.0D, 1.0D, 0.0D, 1.0D, 4.0D, 16.0D),
            Block.box(1.0D, 1.0D, 0.0D, 15.0D, 4.0D, 1.0D),
            Block.box(15.0D, 1.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(1, 1.0D, 15.0D, 15.0D, 4.0D, 16.0D)
    );


    public DressedHerringBlock() {
        super(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOL));
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, Integer.valueOf(0)));
    }

    public DressedHerringBlock(float saturation) {
        this();
        this.SATURATION_MOD = saturation;
    }

    public DressedHerringBlock(BlockBehaviour.Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, Integer.valueOf(0)));
    }

    public DressedHerringBlock(BlockBehaviour.Properties p_49795_, float saturation) {
        this(p_49795_);
        this.SATURATION_MOD = saturation;
    }

    public VoxelShape getShape(BlockState p_51222_, BlockGetter p_51223_, BlockPos p_51224_, CollisionContext p_51225_) {
        return Shapes.or(SHAPE_BY_BITE[p_51222_.getValue(BITES)], PLATE_SHAPE);
    }

    public InteractionResult use(BlockState p_51202_, Level p_51203_, BlockPos p_51204_, Player p_51205_, InteractionHand p_51206_, BlockHitResult p_51207_) {
        ItemStack itemstack = p_51205_.getItemInHand(p_51206_);

        if (p_51203_.isClientSide) {
            if (eat(p_51203_, p_51204_, p_51202_, p_51205_).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat(p_51203_, p_51204_, p_51202_, p_51205_);
    }

    protected InteractionResult eat(LevelAccessor p_51186_, BlockPos p_51187_, BlockState p_51188_, Player p_51189_) {
        if (!p_51189_.canEat(false)) {
            return InteractionResult.PASS;
        }
        p_51189_.getFoodData().eat(NUTRITION, SATURATION_MOD);
        applyEffects(p_51189_);

        int i = p_51188_.getValue(BITES);
        p_51186_.gameEvent(p_51189_, GameEvent.EAT, p_51187_);
        if (i < MAX_BITES) {
            p_51186_.setBlock(p_51187_, p_51188_.setValue(BITES, Integer.valueOf(i + 1)), 3);
        } else {
            p_51186_.removeBlock(p_51187_, false);
            p_51186_.gameEvent(p_51189_, GameEvent.BLOCK_DESTROY, p_51187_);
            p_51189_.addItem(new ItemStack(Items.BOWL));
        }

        return InteractionResult.SUCCESS;
    }

    protected void applyEffects(Player p_51189_) {

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51220_) {
        p_51220_.add(BITES);
    }

    public boolean canSurvive(BlockState p_51209_, LevelReader p_51210_, BlockPos p_51211_) {
        return p_51210_.getBlockState(p_51211_.below()).isSolid();
    }

    public BlockState updateShape(BlockState p_51213_, Direction p_51214_, BlockState p_51215_, LevelAccessor p_51216_, BlockPos p_51217_, BlockPos p_51218_) {
        return p_51214_ == Direction.DOWN && !p_51213_.canSurvive(p_51216_, p_51217_)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(p_51213_, p_51214_, p_51215_, p_51216_, p_51217_, p_51218_);
    }
}
