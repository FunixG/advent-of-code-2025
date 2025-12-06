package dev.funixgaming.advent_of_code.twenty_five.day_six;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathSolverTests {

    @Test
    void testDay06() throws Exception {
        final MathSolver mathSolver = new MathSolver();

        Assertions.assertEquals(4277556, mathSolver.getResult());
    }

    @Test
    void testDay06PartTwo() throws Exception {
        final MathCephalopodSolver mathSolver = new MathCephalopodSolver();

        Assertions.assertEquals(3263827, mathSolver.getResult());
    }

}
