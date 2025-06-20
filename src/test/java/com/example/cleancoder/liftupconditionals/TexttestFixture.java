package com.example.cleancoder.liftupconditionals;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                Item.of("+5 Dexterity Vest", 10, 20), //
                Item.of("Aged Brie", 2, 0), //
                Item.of("Elixir of the Mongoose", 5, 7), //
                Item.of("Sulfuras, Hand of Ragnaros", 0, 80), //
                Item.of("Sulfuras, Hand of Ragnaros", -1, 80),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                Item.of("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                Item.of("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }
}
