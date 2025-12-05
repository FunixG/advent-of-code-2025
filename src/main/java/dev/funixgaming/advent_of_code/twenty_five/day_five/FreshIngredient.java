package dev.funixgaming.advent_of_code.twenty_five.day_five;

public final class FreshIngredient {

    public final long startId;
    public final long endId;

    public FreshIngredient(long startId, long endId) {
        this.startId = startId;
        this.endId = endId;
    }

    public boolean isFresh(long id) {
        return id >= startId && id <= endId;
    }

}
