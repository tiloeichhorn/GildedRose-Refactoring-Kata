package com.gildedrose;

class GildedRose {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final int TEN_DAYS_THRESHOLD = 10;
    public static final int FIVE_DAYS_THRESHOLD = 5;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (ItemType.SULFURAS.equals(item.itemType)) {
                continue;
            }
            if (!ItemType.AGED_BRIE.equals(item.itemType)
                    && !ItemType.BACKSTAGE_PASS.equals(item.itemType)) {
                item.quality = Math.max(MIN_QUALITY, item.quality - 1);
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (ItemType.BACKSTAGE_PASS.equals(item.itemType)) {
                        if (item.sellIn <= TEN_DAYS_THRESHOLD) {
                            item.quality = Math.min(MAX_QUALITY, item.quality + 1);
                        }

                        if (item.sellIn <= FIVE_DAYS_THRESHOLD) {
                            item.quality = Math.min(MAX_QUALITY, item.quality + 1);
                        }
                    }
                }
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (!ItemType.AGED_BRIE.equals(item.itemType)) {
                    if (!ItemType.BACKSTAGE_PASS.equals(item.itemType)) {
                        item.quality = Math.max(MIN_QUALITY, item.quality - 1);
                    } else {
                        item.quality = MIN_QUALITY;
                    }
                } else {
                    item.quality = Math.min(MAX_QUALITY, item.quality + 1);
                }
            }
        }
    }
}