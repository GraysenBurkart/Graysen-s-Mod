package net.gray.examplemod.datagen;

import net.gray.examplemod.ExampleMod;
import net.gray.examplemod.block.ModBlocks;
import net.gray.examplemod.block.custom.BooBerryBushBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

import static net.minecraft.world.level.levelgen.SurfaceRules.state;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExampleMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.ALEXANDRITE_STONE_BLOCK);
        blockWithItem(ModBlocks.MAGIC_TREE_BLOCK);
        blockWithItem(ModBlocks.MAGIC_TREE_PLANKS);
        blockWithItem(ModBlocks.MAGIC_TREE_LEAVES);
        blockWithItem(ModBlocks.PURPLE_MOSS_BLOCK);

        makeBush(((SweetBerryBushBlock) ModBlocks.BOO_BERRY_BUSH.get()), "boo_berry_bush_stage", "boo_berry_bush_stage");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(BooBerryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID, "block/" + textureName + state.getValue(BooBerryBushBlock.AGE))).renderType("cutout"));

        return models;
    }


}
