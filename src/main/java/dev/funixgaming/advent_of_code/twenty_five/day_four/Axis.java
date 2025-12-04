package dev.funixgaming.advent_of_code.twenty_five.day_four;

public final class Axis {

    public final int xAxis;
    public final int yAxis;

    public Axis(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    @Override
    public String toString() {
        return "x: " + xAxis + ", y: " + yAxis;
    }
}
