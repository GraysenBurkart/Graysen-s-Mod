package net.gray.examplemod.entity.client;

import net.gray.examplemod.entity.custom.MagicPigEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MagicPigRenderer extends MobRenderer<MagicPigEntity, MagicPigModel<MagicPigEntity>> {
    private static final ResourceLocation PIG_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/magic_pig/magic_pig.png");

    public MagicPigRenderer(EntityRendererProvider.Context p_174340_) {
        super(p_174340_, new MagicPigModel<>(p_174340_.bakeLayer(MagicPigModel.LAYER_LOCATION)), 0.7F);
        this.addLayer(
                new SaddleLayer<>(
                        this, new MagicPigModel<>(p_174340_.bakeLayer(ModelLayers.PIG_SADDLE)), ResourceLocation.withDefaultNamespace("textures/entity/magic_pig/magic_pig.png")
                )
        );
    }

    public ResourceLocation getTextureLocation(MagicPigEntity pEntity) {
        return PIG_LOCATION;
    }
}