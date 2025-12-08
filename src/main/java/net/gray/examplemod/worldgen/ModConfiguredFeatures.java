package net.gray.examplemod.worldgen;

import net.gray.examplemod.ExampleMod;
import net.gray.examplemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ALEXANDRITE_KEY = registerKey("alexandrite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PURPLE_MOSS_STONE_KEY = registerKey("purple_moss_stone");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldAlexandrite = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ALEXANDRITE_STONE_BLOCK.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldPurpleMossStone = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.PURPLE_MOSS_BLOCK.get().defaultBlockState()));

        register(context, OVERWORLD_ALEXANDRITE_KEY, Feature.ORE, new OreConfiguration(overworldAlexandrite, 9));
        register(context, OVERWORLD_PURPLE_MOSS_STONE_KEY, Feature.ORE, new OreConfiguration(overworldPurpleMossStone, 10));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}