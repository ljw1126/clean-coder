package com.example.cleancoder.liftupconditionals;

public class Item {
    public String name;

    public int sellIn;

    public int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item of(String name, int sellIn, int quality) {
        return switch (name) {
            case "Sulfuras, Hand of Ragnaros" -> new Sulfuras(sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert" -> new Backsage(sellIn, quality);
            case "Aged Brie" -> new AgedBrie(sellIn, quality);
            default -> new Item(name, sellIn, quality);
        };
    }

    protected void updateQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0 && quality > 0) {
            quality = quality - 1;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
