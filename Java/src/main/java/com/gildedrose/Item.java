package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;
    public int quality;
    public ItemType itemType;

    public Item(String name, int sellIn, int quality, ItemType itemType) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = Math.max(0, Math.min(quality, 50));
        this.itemType = itemType;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
