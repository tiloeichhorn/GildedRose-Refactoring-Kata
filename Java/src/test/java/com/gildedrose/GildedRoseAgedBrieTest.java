package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseAgedBrieTest {

    public static final String AGED_BRIE = "Aged Brie";

    @Test
    void testAgedBrie() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 8, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(AGED_BRIE);
        assertThat(app.items[0].quality).isEqualTo(6);
        assertThat(app.items[0].sellIn).isEqualTo(7);
    }

    @Test
    void testAgedBrieSellByDateIsNow() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(AGED_BRIE);
        assertThat(app.items[0].quality).isEqualTo(7);
        assertThat(app.items[0].sellIn).isEqualTo(-1);
    }

    @Test
    void testAgedBrieSellByDatePassed() {
        Item[] items = new Item[] { new Item(AGED_BRIE, -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(AGED_BRIE);
        assertThat(app.items[0].quality).isEqualTo(7);
        assertThat(app.items[0].sellIn).isEqualTo(-2);
    }

}
