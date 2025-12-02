package net.gray.examplemod.util;

import net.gray.examplemod.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import static net.gray.examplemod.util.ModTags.Blocks.createTag;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_FAE_TOOL = createTag("needs_fae_tool");
        public static final TagKey<Block> INCORRECT_FOR_FAE_TOOL = createTag("incorrect_for_fae_tool");

        public static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEM = createTag("transformable_item");

        public static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID, name));
        }
    }
}
