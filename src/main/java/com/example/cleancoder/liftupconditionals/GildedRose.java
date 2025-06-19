package com.example.cleancoder.liftupconditionals;

/**
 * 출처: https://github.com/emilybache/GildedRose-Refactoring-Kata
 */
public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateQuality();
        }
    }

}
