package com.gildedrose;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.gildedrose.itemDaySimulation.AgedBrieItemDaySimulationStrategy;
import com.gildedrose.itemDaySimulation.BackstagePassItemDaySimulationStrategy;
import com.gildedrose.itemDaySimulation.ItemDaySimulationStrategy;
import com.gildedrose.itemDaySimulation.StandardItemDaySimulationStrategy;
import com.gildedrose.itemDaySimulation.SulfurasItemDaySimulationStrategy;

public class GildedRose {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    Item[] items;

    private static final Map<ItemType, ItemDaySimulationStrategy> simulationStrategies = new HashMap<ItemType, ItemDaySimulationStrategy>() {{
        put(ItemType.STANDARD, new StandardItemDaySimulationStrategy());
        put(ItemType.AGED_BRIE, new AgedBrieItemDaySimulationStrategy());
        put(ItemType.BACKSTAGE_PASS, new BackstagePassItemDaySimulationStrategy());
        put(ItemType.SULFURAS, new SulfurasItemDaySimulationStrategy());
    }};

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Simulates a day and updates the quality and sellIn value on all items according to their item type.
     */
    public void simulateDay() {
        for (Item item : items) {
            Optional.of(simulationStrategies.get(item.itemType))
                    .ifPresent(itemDaySimulationStrategy -> itemDaySimulationStrategy.simulate(item));
        }
    }
}