package dev.funixgaming.advent_of_code.twenty_five;

import dev.funixgaming.advent_of_code.twenty_five.day_one.SafeSolver;
import dev.funixgaming.advent_of_code.twenty_five.day_two.GiftShopIdHandler;

public final class Main {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        day02StepTwo();

        long elapsedTime = System.currentTimeMillis()-start;
        System.out.println("ElapsedTime: " + elapsedTime + "ms");
    }

    private static void day01() throws Exception {
        final SafeSolver safeSolver = new SafeSolver();
        System.out.println("SafeCode: " + safeSolver.getPassword());
    }

    private static void day01Step2() throws Exception {
        final SafeSolver safeSolver = new SafeSolver();

        safeSolver.enableZeroCounting();
        System.out.println("SafeCode: " + safeSolver.getPassword());
    }

    private static void day02() throws Exception {
        final GiftShopIdHandler giftShopIdHandler = new GiftShopIdHandler();
        System.out.println("Sum: " + giftShopIdHandler.getSumOfInvalidIds());
    }

    private static void day02StepTwo() throws Exception {
        final GiftShopIdHandler giftShopIdHandler = new GiftShopIdHandler();

        giftShopIdHandler.partTwo = true;
        System.out.println("Sum: " + giftShopIdHandler.getSumOfInvalidIds());
    }

}
