package net.gray.examplemod.event;

import net.gray.examplemod.Item.ModItems;
import net.gray.examplemod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades (VillagerTradesEvent event){
        if(event.getType() == ModVillagers.JEWELER.get()) {
            var trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(ModItems.DRAGON_FRUIT.get(), 10), 6, 4, 0.05f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND, 5),
                    new ItemStack(ModItems.ALEXANDRITE.get(), 15), 6, 10, 0.05f));
        }
    }
}
