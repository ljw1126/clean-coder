package com.example.cleancoder.liftupconditionals;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] {Item.of("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("foo");
    }

}
