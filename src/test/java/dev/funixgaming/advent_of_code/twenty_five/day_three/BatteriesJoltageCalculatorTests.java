package dev.funixgaming.advent_of_code.twenty_five.day_three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BatteriesJoltageCalculatorTests {

    @Test
    void testDay03() throws Exception {
        final BatteriesJoltageCalculator batteriesJoltageCalculator = new BatteriesJoltageCalculator();
        Assertions.assertEquals(357, batteriesJoltageCalculator.getTotalOutput());
    }

    @Test
    void testDay03StepTwo() throws Exception {

    }

}
