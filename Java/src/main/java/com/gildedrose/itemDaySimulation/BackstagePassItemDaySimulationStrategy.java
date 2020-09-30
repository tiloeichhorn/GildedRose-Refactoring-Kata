package com.gildedrose.itemDaySimulation;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;

public class BackstagePassItemDaySimulationStrategy implements ItemDaySimulationStrategy {

    public static final int TEN_DAYS_THRESHOLD = 10;
    public static final int FIVE_DAYS_THRESHOLD = 5;

    @Override
    public void simulate(Item item) {
        item.quality++;

        if (item.sellIn <= TEN_DAYS_THRESHOLD) {
            item.quality++;
        }

        if (item.sellIn <= FIVE_DAYS_THRESHOLD) {
            item.quality++;
        }

        item.quality = Math.min(GildedRose.MAX_QUALITY, item.quality);

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = GildedRose.MIN_QUALITY;
        }
    }
}
