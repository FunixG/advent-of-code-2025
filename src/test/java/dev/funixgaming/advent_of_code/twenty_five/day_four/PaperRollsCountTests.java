package dev.funixgaming.advent_of_code.twenty_five.day_four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaperRollsCountTests {

    @Test
    void testDay04() throws Exception {
        final PaperRollsCount paperRollsCount = new PaperRollsCount();

        Assertions.assertEquals(13, paperRollsCount.countForklifts());
    }

    @Test
    void testDay04PartTwo() throws Exception {
        final PaperRollsCount paperRollsCount = new PaperRollsCount();

        paperRollsCount.removeAll = true;
        Assertions.assertEquals(43, paperRollsCount.countForklifts());
    }

}
