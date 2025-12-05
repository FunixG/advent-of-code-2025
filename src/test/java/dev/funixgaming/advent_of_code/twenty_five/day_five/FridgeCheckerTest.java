package dev.funixgaming.advent_of_code.twenty_five.day_five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FridgeCheckerTest {

    @Test
    void testDay05() throws Exception {
        final FridgeChecker fridgeChecker = new FridgeChecker();

        Assertions.assertEquals(3, fridgeChecker.countFreshIngredients());
    }

    @Test
    void testDay05PartTwo() throws Exception {
        final FridgeChecker fridgeChecker = new FridgeChecker();

        fridgeChecker.partTwo = true;
        Assertions.assertEquals(14, fridgeChecker.countFreshIngredients());
    }

}
