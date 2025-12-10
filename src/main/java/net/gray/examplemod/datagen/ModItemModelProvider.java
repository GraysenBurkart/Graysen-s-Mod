package net.gray.examplemod.datagen;

import net.gray.examplemod.ExampleMod;
import net.gray.examplemod.Item.ModItems;
import net.gray.examplemod.block.ModBlocks;
import net.gray.examplemod.Item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExampleMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ALEXANDRITE.get());

        basicItem(ModItems.DRAGON_FRUIT.get());


//        buttonItem(ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_BLOCK);
//        fenceItem(ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_BLOCK);
//        wallItem(ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_BLOCK);
//
//        simpleBlockItem(ModBlocks.ALEXANDRITE_DOOR);

        handheldItem(ModItems.FAE_SWORD);
        handheldItem(ModItems.FAE_PICKAXE);
        handheldItem(ModItems.FAE_SHOVEL);
        handheldItem(ModItems.FAE_AXE);
        handheldItem(ModItems.FAE_HOE);

        basicItem(ModItems.BOO_BERRIES.get());

        saplingItem(ModBlocks.MAGIC_SAPLING);

        withExistingParent(ModItems.MAGIC_PIG_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        assert item.getId() != null;
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID,"item/" + item.getId().getPath()));
    }

//    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
//        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
//                .texture("texture",  ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID,
//                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
//    }

//    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
//        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
//                .texture("texture",  ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID,
//                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
//    }

//    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
//        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
//                .texture("wall",  ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID,
//                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
//    }

//    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
//        return withExistingParent(item.getId().getPath(),
//                ResourceLocation.parse("item/generated")).texture("layer0",
//                ResourceLocation.fromNamespaceAndPath(ExampleMod.MODID,"item/" + item.getId().getPath()));
//    }
}