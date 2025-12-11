package net.gray.examplemod.block;

import net.gray.examplemod.ExampleMod;
import net.gray.examplemod.Item.ModItems;
import net.gray.examplemod.block.custom.BooBerryBushBlock;
import net.gray.examplemod.block.custom.ChairBlock;
import net.gray.examplemod.block.custom.ModFlammableRotatedPillarBlock;
import net.gray.examplemod.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);

    public static final RegistryObject<Block> ALEXANDRITE_STONE_BLOCK = registryBlock("alexandrite_stone_block.json.json",
            () -> new DropExperienceBlock(UniformInt.of(2,5),BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registryBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.AMETHYST)));

    public static final RegistryObject<RotatedPillarBlock> MAGIC_TREE_BLOCK = registryBlock("magic_tree_block",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(3f).sound(SoundType.WOOD)));

    public final static RegistryObject<Block> MAGIC_TREE_PLANKS = registryBlock("magic_tree_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            }
            );

    public static final RegistryObject<Block> MAGIC_TREE_LEAVES = registryBlock("magic_tree_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            }
            );

    public static final RegistryObject<Block> MAGIC_SAPLING = registryBlock("magid_sapling",
            () -> new SaplingBlock(ModTreeGrowers.MAGIC, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> CHAIR = registryBlock("chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().noOcclusion()));

    public static final RegistryObject<Block> PURPLE_MOSS_BLOCK = registryBlock("purple_moss_block.json.json",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BOO_BERRY_BUSH = BLOCKS.register("boo_berry_bush",
            () -> new BooBerryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));



    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
