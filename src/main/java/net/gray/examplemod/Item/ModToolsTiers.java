package net.gray.examplemod.Item;

import net.gray.examplemod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;

public class ModToolsTiers {
    public static final Tier FAE = new ForgeTier(1400, 4, 3f, 20,
            ModTags.Blocks.NEEDS_FAE_TOOL, () -> Ingredient.of(ModItems.ALEXANDRITE.get()),
            ModTags.Blocks.INCORRECT_FOR_FAE_TOOL);
}
