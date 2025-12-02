package dev.funixgaming.advent_of_code.twenty_five.day_two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GiftShopIdHandlerTests {

    @Test
    void testDay02() throws Exception {
        final GiftShopIdHandler giftShopIdHandler = new GiftShopIdHandler();

        Assertions.assertEquals(1227775554, giftShopIdHandler.getSumOfInvalidIds());
    }

    @Test
    void testDay02PartTwo() throws Exception {
        final GiftShopIdHandler giftShopIdHandler = new GiftShopIdHandler();

        giftShopIdHandler.partTwo = true;
        Assertions.assertEquals(4174379265L, giftShopIdHandler.getSumOfInvalidIds());
    }

}
