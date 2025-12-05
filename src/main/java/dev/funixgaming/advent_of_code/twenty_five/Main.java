package dev.funixgaming.advent_of_code.twenty_five;

import dev.funixgaming.advent_of_code.twenty_five.day_five.FridgeChecker;
import dev.funixgaming.advent_of_code.twenty_five.day_four.PaperRollsCount;
import dev.funixgaming.advent_of_code.twenty_five.day_one.SafeSolver;
import dev.funixgaming.advent_of_code.twenty_five.day_three.BatteriesJoltageCalculator;
import dev.funixgaming.advent_of_code.twenty_five.day_two.GiftShopIdHandler;

public final class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Start !");
        long start = System.currentTimeMillis();

        day05PartTwo();

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

    private static void day03() throws Exception {
        final BatteriesJoltageCalculator calculator = new BatteriesJoltageCalculator();

        System.out.println("Batteries: " + calculator.getTotalOutput());
    }

    private static void day03StepTwo() throws Exception {

    }

    private static void day04() throws Exception {
        final PaperRollsCount paperRollsCount = new PaperRollsCount();

        System.out.println("Forklits: " + paperRollsCount.countForklifts());
    }

    private static void day04PartTwo() throws Exception {
        final PaperRollsCount paperRollsCount = new PaperRollsCount();

        paperRollsCount.removeAll = true;
        System.out.println("Forklits: " + paperRollsCount.countForklifts());
    }

    private static void day05() throws Exception {
        final FridgeChecker fridgeChecker = new FridgeChecker();

        System.out.println("FreshCount: " + fridgeChecker.countFreshIngredients());
    }

    private static void day05PartTwo() throws Exception {
        final FridgeChecker fridgeChecker = new FridgeChecker();

        fridgeChecker.partTwo = true;
        System.out.println("FreshCount: " + fridgeChecker.countFreshIngredients());
    }

}
