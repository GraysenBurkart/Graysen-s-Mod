package net.gray.examplemod.worldgen;

import net.gray.examplemod.ExampleMod;
import net.gray.examplemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ALEXANDRITE_STONE_BLOCK_KEY = registerKey("alexandrite_stone_block.json.json");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PURPLE_MOSS_BLOCK_KEY = registerKey("purple_moss_block.json.json");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGIC_KEY = registerKey("magic_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BOO_BERRY_BUSH_KEY = registerKey("boo_berry_bush_key");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldAlexandrite = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ALEXANDRITE_STONE_BLOCK.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldPurpleMossStone = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.PURPLE_MOSS_BLOCK.get().defaultBlockState()));

        register(context, OVERWORLD_ALEXANDRITE_STONE_BLOCK_KEY, Feature.ORE, new OreConfiguration(overworldAlexandrite, 9));
        register(context, OVERWORLD_PURPLE_MOSS_BLOCK_KEY, Feature.ORE, new OreConfiguration(overworldPurpleMossStone, 9));

        register(context, MAGIC_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MAGIC_TREE_BLOCK.get()),
                new ForkingTrunkPlacer(4, 4, 3),

                BlockStateProvider.simple(ModBlocks.MAGIC_TREE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, BOO_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BOO_BERRY_BUSH.get().defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK)));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
