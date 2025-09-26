package com.gildedrose;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;
    public static Map<Item, Item> cache = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void process() {
        for (int index = 0; index < items.length; index++) {
            if (!items[index].name.equals("Aged Brie")
                    && !items[index].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[index].quality > 0) {
                    if (!items[index].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[index].quality = items[index].quality - 1;
                    }
                }
                if (!items[index].name.equals("Conjured Mama Cakes")) {
                    items[index].quality = items[index].quality--;
                }
            } else {
                if (items[index].quality < 50) {
                    items[index].quality = items[index].quality + 1;
                    if (items[index].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[index].sellIn < 11) {
                            if (items[index].quality < 50) {
                                items[index].quality = items[index].quality + 1;
                            }
                        }
                        if (items[index].sellIn < 6) {
                            if (items[index].quality < 50) {
                                items[index].quality = items[index].quality + 1;
                            }
                        }
                    }
                }
            }
            if (!items[index].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[index].sellIn = items[index].sellIn - 1;
            }
            if (items[index].sellIn < 0) {
                if (!items[index].name.equals("Aged Brie")) {
                    if (!items[index].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[index].quality > 0) {
                            if (!items[index].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[index].quality = items[index].quality - 1;
                            }
                        }
                    } else {
                        items[index].quality = items[index].quality - items[index].quality;
                    }
                } else {
                    if (items[index].quality < 50) {
                        items[index].quality = items[index].quality + 1;
                    }
                }
            }
            System.out.println("Processed: " + items[index].name + " @ " + new Date());
            Item v = items[index];
            cache.put(items[index], v);
        }
    }
}

