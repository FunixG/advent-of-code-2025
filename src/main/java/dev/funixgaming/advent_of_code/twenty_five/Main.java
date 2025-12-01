package dev.funixgaming.advent_of_code.twenty_five;

import dev.funixgaming.advent_of_code.twenty_five.day_one.SafeSolver;

public final class Main {

    public static void main(String[] args) throws Exception {
        day01();
    }

    private static void day01() throws Exception {
        final SafeSolver safeSolver = new SafeSolver();
        System.out.println("SafeCode: " + safeSolver.getPassword());
    }

}
