package net.gray.examplemod.datagen;

import net.gray.examplemod.ExampleMod;
import net.gray.examplemod.block.ModBlocks;
import net.gray.examplemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExampleMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ALEXANDRITE_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ALEXANDRITE_STONE_BLOCK.get())
                .add(ModBlocks.PURPLE_MOSS_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL);

//        tag(BlockTags.FENCES).add(ModBlocks.ALEXANDRITE_FENCE.get());
//        tag(BlockTags.FENCE_GATES).add(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
//        tag(BlockTags.WALLS).add(ModBlocks.ALEXANDRITE_WALL.get());

//        tag(ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL)
//                .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
//                .add(Blocks.OBSIDIAN)
//                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_FAE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_FAE_TOOL);

        tag(ModTags.Blocks.NEEDS_FAE_TOOL)
                .add(ModBlocks.ALEXANDRITE_STONE_BLOCK.get())
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_FAE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_FAE_TOOL);
    }
}