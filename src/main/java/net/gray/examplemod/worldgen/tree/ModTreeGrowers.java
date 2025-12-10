package net.gray.examplemod.worldgen.tree;

import net.gray.examplemod.ExampleMod;
import net.gray.examplemod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower MAGIC = new TreeGrower(ExampleMod.MODID + ":magic",
            Optional.empty(), Optional.of(ModConfiguredFeatures.MAGIC_KEY), Optional.empty());
}
