package net.gray.examplemod.Item;

import net.gray.examplemod.ExampleMod;
import net.gray.examplemod.block.ModBlocks;
import net.gray.examplemod.entity.ModEntities;
import net.minecraft.world.item.*;

import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LARGE_BOTTLE = ITEMS.register("large_bottle",
            () -> new BottleItem(new Item.Properties()));

    public static final RegistryObject<Item> UNBREAKABLE_BOTTLE = ITEMS.register("unbreakable_bottle",
            () -> new BottleItem(new Item.Properties()));

    public static final RegistryObject<Item> BOO_BERRIES = ITEMS.register("boo_berries",
            () -> new ItemNameBlockItem(ModBlocks.BOO_BERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.BOO_BERRIES)));

    public static final RegistryObject<Item> DRAGON_FRUIT = ITEMS.register("dragon_fruit",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DRAGON_FRUIT)));

    public static final RegistryObject<Item> FAE_SWORD = ITEMS.register("fae_sword",
            () -> new SwordItem(ModToolsTiers.FAE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolsTiers.FAE, 3, -2.4f))));

    public static final RegistryObject<Item> FAE_AXE = ITEMS.register("fae_axe",
            () -> new AxeItem(ModToolsTiers.FAE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolsTiers.FAE, 6, -3.2f))));

    public static final RegistryObject<Item> FAE_PICKAXE = ITEMS.register("fae_pickaxe",
            () -> new PickaxeItem(ModToolsTiers.FAE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolsTiers.FAE, 1, -2.4f))));

    public static final RegistryObject<Item> FAE_SHOVEL = ITEMS.register("fae_shovel",
            () -> new ShovelItem(ModToolsTiers.FAE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolsTiers.FAE, 1, -3.0f))));

    public static final RegistryObject<Item> FAE_HOE = ITEMS.register("fae_hoe",
            () -> new HoeItem(ModToolsTiers.FAE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolsTiers.FAE, 0, -3f))));

    public static final RegistryObject<Item> MAGIC_PIG_SPAWN_EGG = ITEMS.register("magic_pig_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MAGIC_PIG, 0x5324b, 0xdac741, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
