package com.gildedrose.itemDaySimulation;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.ItemType;
import com.gildedrose.itemDaySimulation.ItemDaySimulationStrategy;

public class BackstagePassItemDaySimulationStrategy implements ItemDaySimulationStrategy {

    public static final int TEN_DAYS_THRESHOLD = 10;
    public static final int FIVE_DAYS_THRESHOLD = 5;

    @Override
    public void simulate(Item item) {
        if (item.quality < GildedRose.MAX_QUALITY) {
            item.quality = item.quality + 1;

            if (ItemType.BACKSTAGE_PASS.equals(item.itemType)) {
                if (item.sellIn <= TEN_DAYS_THRESHOLD) {
                    item.quality = Math.min(GildedRose.MAX_QUALITY, item.quality + 1);
                }

                if (item.sellIn <= FIVE_DAYS_THRESHOLD) {
                    item.quality = Math.min(GildedRose.MAX_QUALITY, item.quality + 1);
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (ItemType.BACKSTAGE_PASS.equals(item.itemType)) {
                item.quality = GildedRose.MIN_QUALITY;
            }
        }
    }
}
