package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseSulfurasTest {

    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    @Test
    void testSulfuras() {
        Item[] items = new Item[] { new Item(SULFURAS_HAND_OF_RAGNAROS, 8, 10, ItemType.SULFURAS) };
        GildedRose app = new GildedRose(items);
        app.simulateDay();
        assertThat(app.items[0].name).isEqualTo(SULFURAS_HAND_OF_RAGNAROS);
        assertThat(app.items[0].quality).isEqualTo(10);
        assertThat(app.items[0].sellIn).isEqualTo(8);
    }

    @Test
    void testSulfurasNegativeQuality() {
        Item[] items = new Item[] { new Item(SULFURAS_HAND_OF_RAGNAROS, 8, -500, ItemType.SULFURAS) };
        GildedRose app = new GildedRose(items);
        app.simulateDay();
        assertThat(app.items[0].name).isEqualTo(SULFURAS_HAND_OF_RAGNAROS);
        assertThat(app.items[0].quality).isEqualTo(0);
        assertThat(app.items[0].sellIn).isEqualTo(8);
    }

    @Test
    void testSulfurasSellByDateIsNow() {
        Item[] items = new Item[] { new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 50, ItemType.SULFURAS) };
        GildedRose app = new GildedRose(items);
        app.simulateDay();
        assertThat(app.items[0].name).isEqualTo(SULFURAS_HAND_OF_RAGNAROS);
        assertThat(app.items[0].quality).isEqualTo(50);
        assertThat(app.items[0].sellIn).isEqualTo(0);
    }

    @Test
    void testSulfurasSellByDatePassed() {
        Item[] items = new Item[] { new Item(SULFURAS_HAND_OF_RAGNAROS, -1, 20, ItemType.SULFURAS) };
        GildedRose app = new GildedRose(items);
        app.simulateDay();
        assertThat(app.items[0].name).isEqualTo(SULFURAS_HAND_OF_RAGNAROS);
        assertThat(app.items[0].quality).isEqualTo(20);
        assertThat(app.items[0].sellIn).isEqualTo(-1);
    }

}
