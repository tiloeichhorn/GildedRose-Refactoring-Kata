package com.gildedrose.itemDaySimulation;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.ItemType;

/**
 * {@link ItemDaySimulationStrategy} for {@link ItemType#STANDARD} that implements behaviour of standard items.
 */
public class StandardItemDaySimulationStrategy implements ItemDaySimulationStrategy {

    @Override
    public void simulate(Item item) {
        item.quality = Math.max(GildedRose.MIN_QUALITY, item.quality - 1);
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = Math.max(GildedRose.MIN_QUALITY, item.quality - 1);
        }
    }
}
