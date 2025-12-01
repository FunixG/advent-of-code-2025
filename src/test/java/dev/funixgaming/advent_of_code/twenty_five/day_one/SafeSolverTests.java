package dev.funixgaming.advent_of_code.twenty_five.day_one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SafeSolverTests {

    @Test
    void testPassword() throws Exception {
        final SafeSolver safeSolver = new SafeSolver();

        Assertions.assertEquals(3, safeSolver.getPassword());
    }

}
