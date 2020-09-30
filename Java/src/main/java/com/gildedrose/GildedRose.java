package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final int TEN_DAYS_THRESHOLD = 10;
    public static final int FIVE_DAYS_THRESHOLD = 5;
    Item[] items;

    private static final Map<ItemType, ItemDaySimulationStrategy> simulationStrategies = new HashMap<ItemType, ItemDaySimulationStrategy>() {{
        put(ItemType.SULFURAS, new SulfurasItemDaySimulationStrategy());
        put(ItemType.STANDARD, new StandardItemDaySimulationStrategy());
        put(ItemType.AGED_BRIE, new AgedBrieItemDaySimulationStrategy());
    }};

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (simulationStrategies.containsKey(item.itemType)) {
                simulationStrategies.get(item.itemType).simulate(item);
                continue;
            }
            if (item.quality < MAX_QUALITY) {
                item.quality = item.quality + 1;

                if (ItemType.BACKSTAGE_PASS.equals(item.itemType)) {
                    if (item.sellIn <= TEN_DAYS_THRESHOLD) {
                        item.quality = Math.min(MAX_QUALITY, item.quality + 1);
                    }

                    if (item.sellIn <= FIVE_DAYS_THRESHOLD) {
                        item.quality = Math.min(MAX_QUALITY, item.quality + 1);
                    }
                }
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (ItemType.BACKSTAGE_PASS.equals(item.itemType)) {
                    item.quality = MIN_QUALITY;
                }
            }
        }
    }
}