package com.gildedrose;

/**
 * {@link ItemDaySimulationStrategy} for {@link ItemType#SULFURAS} that does prevent any changes.
 */
public class SulfurasItemDaySimulationStrategy implements ItemDaySimulationStrategy {

    @Override
    public void simulate(Item item) {
        // does nothing!
    }
}
