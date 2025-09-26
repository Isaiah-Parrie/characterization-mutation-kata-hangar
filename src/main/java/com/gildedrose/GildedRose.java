package com.gildedrose;


class GildedRose {
    Item[] items;
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void process() {
        for (int index = 0; index < items.length; index++) {
            if (!items[index].name.equals("Aged Brie")
                    && !items[index].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                notBrieAndBackstagePassLogic(index);
            } else {
                if (items[index].quality < MAX_QUALITY) {
                    lessThanMaxQualityLogic(index);
                }
            }
            if (!items[index].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[index].sellIn = items[index].sellIn - 1;
            }
            if (items[index].sellIn < 0) {
                itemsSelling(index);
            }
        }
    }

    private void itemsSelling(int index) {
        if (!items[index].name.equals("Aged Brie")) {
            if (!items[index].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[index].quality > MIN_QUALITY) {
                    if (!items[index].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[index].quality = decrementQualityByOne(index);
                    }
                }
            } else {
                items[index].quality = items[index].quality - items[index].quality;
            }
        } else {
            lessThanMaxQualityCheckAndIncrement(index);
        }
    }

    private void lessThanMaxQualityCheckAndIncrement(int index) {
        if (items[index].quality < MAX_QUALITY) {
            items[index].quality = incrementQualityByOne(index);
        }
    }

    private int decrementQualityByOne(int index) {
        return items[index].quality - 1;
    }

    private void lessThanMaxQualityLogic(int index) {
        items[index].quality = incrementQualityByOne(index);
        if (items[index].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items[index].sellIn < 11) {
                lessThanMaxQualityCheckAndIncrement(index);
            }
            if (items[index].sellIn < 6) {
                lessThanMaxQualityCheckAndIncrement(index);
            }
        }
    }

    private int incrementQualityByOne(int index) {
        return items[index].quality + 1;
    }

    private void notBrieAndBackstagePassLogic(int index) {
        if (items[index].quality > MIN_QUALITY) {
            if (!items[index].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[index].quality = decrementQualityByOne(index);
            }
        }
        if (!items[index].name.equals("Conjured Mama Cakes")) {
            items[index].quality = items[index].quality--;
        }
    }
}

