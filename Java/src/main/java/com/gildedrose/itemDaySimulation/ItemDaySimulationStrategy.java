package com.gildedrose.itemDaySimulation;

import com.gildedrose.Item;

/**
 * Strategy to update an item and simulate the quality decay and sell in (days) changes over one day.
 */
public interface ItemDaySimulationStrategy {

    /**
     * Simulate the daily changes for an item.
     * Can reduce or increase the item quality.
     * Can reduce the sell in (days) counter.
     * @param item {@link Item} to update for the next day.
     */
    void simulate(Item item);
}
