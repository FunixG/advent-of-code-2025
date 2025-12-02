package dev.funixgaming.advent_of_code.twenty_five.day_two;

public final class ShopRange {

    private final long startId;

    private final long endId;

    public ShopRange(long startId, long endId) {
        this.startId = startId;
        this.endId = endId;
    }

    public long getStartId() {
        return startId;
    }

    public long getEndId() {
        return endId;
    }
}
