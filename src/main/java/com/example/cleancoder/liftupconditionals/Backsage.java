package com.example.cleancoder.liftupconditionals;

public class Backsage extends Item {
    public Backsage(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;

            if (sellIn < 11 && quality < 50) {
                quality = quality + 1;
            }

            if (sellIn < 6 && quality < 50) {
                quality = quality + 1;
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }
    }
}
