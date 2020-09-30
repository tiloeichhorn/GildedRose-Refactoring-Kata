package com.gildedrose.itemDaySimulation;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.ItemType;
import com.gildedrose.itemDaySimulation.ItemDaySimulationStrategy;

/**
 * {@link ItemDaySimulationStrategy} for {@link ItemType#AGED_BRIE} that implements behaviour of aged brie.
 */
public class AgedBrieItemDaySimulationStrategy implements ItemDaySimulationStrategy {

    @Override
    public void simulate(Item item) {
        item.quality = Math.min(GildedRose.MAX_QUALITY, item.quality + 1);

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = Math.min(GildedRose.MAX_QUALITY, item.quality + 1);
        }
    }
}
