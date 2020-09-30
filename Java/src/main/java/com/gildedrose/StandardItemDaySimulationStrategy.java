package com.gildedrose;

/**
 * {@link ItemDaySimulationStrategy} for {@link ItemType#STANDARD} that implements behaviour of standard items.
 */
public class StandardItemDaySimulationStrategy implements ItemDaySimulationStrategy {

    @Override
    public void simulate(Item item) {
        item.quality = Math.max(GildedRose.MIN_QUALITY, item.quality - 1);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = Math.max(GildedRose.MIN_QUALITY, item.quality - 1);
        }
    }
}
