package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseBackstagePassTest {

    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void testBackstagePass() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 80, 5, ItemType.BACKSTAGE_PASS) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(BACKSTAGE_PASS);
        assertThat(app.items[0].quality).isEqualTo(6);
        assertThat(app.items[0].sellIn).isEqualTo(79);
    }

    @Test
    void testBackstagePassSellByDateIn10() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 10, 7, ItemType.BACKSTAGE_PASS) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(BACKSTAGE_PASS);
        assertThat(app.items[0].quality).isEqualTo(9);
        assertThat(app.items[0].sellIn).isEqualTo(9);
    }

    @Test
    void testBackstagePassSellByDateIn5() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 5, 20, ItemType.BACKSTAGE_PASS) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(BACKSTAGE_PASS);
        assertThat(app.items[0].quality).isEqualTo(23);
        assertThat(app.items[0].sellIn).isEqualTo(4);
    }

    @Test
    void testBackstagePassSellByDateIsTomorrow() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 1, 5, ItemType.BACKSTAGE_PASS) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(BACKSTAGE_PASS);
        assertThat(app.items[0].quality).isEqualTo(8);
        assertThat(app.items[0].sellIn).isEqualTo(0);
    }

    @Test
    void testBackstagePassSellByDateIsNow() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 0, 5, ItemType.BACKSTAGE_PASS) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(BACKSTAGE_PASS);
        assertThat(app.items[0].quality).isEqualTo(0);
        assertThat(app.items[0].sellIn).isEqualTo(-1);
    }

    @Test
    void testBackstagePassByDatePassed() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASS, -1, 5, ItemType.BACKSTAGE_PASS) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(BACKSTAGE_PASS);
        assertThat(app.items[0].quality).isEqualTo(0);
        assertThat(app.items[0].sellIn).isEqualTo(-2);
    }

}
