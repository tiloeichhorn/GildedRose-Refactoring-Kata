package com.gildedrose.itemDaySimulation;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

/**
 * {@link ItemDaySimulationStrategy} for {@link ItemType#SULFURAS} that does prevent any changes.
 */
public class SulfurasItemDaySimulationStrategy implements ItemDaySimulationStrategy {

    @Override
    public void simulate(Item item) {
        // does nothing!
    }
}
