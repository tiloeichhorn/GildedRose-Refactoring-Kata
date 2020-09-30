package com.gildedrose;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class GildedRose {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    Item[] items;

    private static final Map<ItemType, ItemDaySimulationStrategy> simulationStrategies = new HashMap<ItemType, ItemDaySimulationStrategy>() {{
        put(ItemType.SULFURAS, new SulfurasItemDaySimulationStrategy());
        put(ItemType.STANDARD, new StandardItemDaySimulationStrategy());
        put(ItemType.AGED_BRIE, new AgedBrieItemDaySimulationStrategy());
        put(ItemType.BACKSTAGE_PASS, new BackstagePassItemDaySimulationStrategy());
    }};

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            Optional.of(simulationStrategies.get(item.itemType))
                    .ifPresent(itemDaySimulationStrategy -> itemDaySimulationStrategy.simulate(item));
        }
    }
}