package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!ItemType.AGED_BRIE.equals(item.itemType)
                    && !ItemType.BACKSTAGE_PASS.equals(item.itemType)) {
                if (item.quality > 0) {
                    if (!ItemType.SULFURAS.equals(item.itemType)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (ItemType.BACKSTAGE_PASS.equals(item.itemType)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!ItemType.SULFURAS.equals(item.itemType)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!ItemType.AGED_BRIE.equals(item.itemType)) {
                    if (!ItemType.BACKSTAGE_PASS.equals(item.itemType)) {
                        if (item.quality > 0) {
                            if (!ItemType.SULFURAS.equals(item.itemType)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}