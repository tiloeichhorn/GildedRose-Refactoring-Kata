package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseStandardProductTest {

    public static final String STANDARD_PRODUCT = "Standard Product";

    @Test
    void testRandomStandardProduct() {
        Item[] items = new Item[] { new Item(STANDARD_PRODUCT, 10, 5, ItemType.STANDARD) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(STANDARD_PRODUCT);
        assertThat(app.items[0].quality).isEqualTo(4);
        assertThat(app.items[0].sellIn).isEqualTo(9);
    }

    @Test
    void testRandomStandardProductSellByDateIsNow() {
        Item[] items = new Item[] { new Item(STANDARD_PRODUCT, 0, 4, ItemType.STANDARD) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(STANDARD_PRODUCT);
        assertThat(app.items[0].quality).isEqualTo(2);
        assertThat(app.items[0].sellIn).isEqualTo(-1);
    }

    @Test
    void testRandomStandardProductSellByDatePassed() {
        Item[] items = new Item[] { new Item(STANDARD_PRODUCT, -5, 4, ItemType.STANDARD) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo(STANDARD_PRODUCT);
        assertThat(app.items[0].quality).isEqualTo(2);
        assertThat(app.items[0].sellIn).isEqualTo(-6);
    }

}
