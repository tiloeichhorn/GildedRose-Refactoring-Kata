package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void testRandomStandardProduct() {
        Item[] items = new Item[] { new Item("foo", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("foo");
        assertThat(app.items[0].quality).isEqualTo(4);
        assertThat(app.items[0].sellIn).isEqualTo(9);
    }

}
