package dev.funixgaming.advent_of_code.twenty_five.day_three;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

public final class BatteriesJoltageCalculator {

    private final List<String> batteriesBanks;

    public BatteriesJoltageCalculator() throws Exception {
        this.batteriesBanks = this.readFromClasspath();
    }

    public int getTotalOutput() {
        int totalOutput = 0;
        BatteryJoltage firstMax;
        BatteryJoltage secondMax;
        String bankMaxStr;

        for (final String bank : this.batteriesBanks) {
            firstMax = this.getLargestNumber(bank, new BatteryJoltage(-1, -1));
            secondMax = this.getLargestNumber(bank, new BatteryJoltage(-1, firstMax.position));
            bankMaxStr = "" + firstMax.joltage + secondMax.joltage;

            totalOutput += Integer.parseInt(bankMaxStr);
        }

        return totalOutput;
    }

    private BatteryJoltage getLargestNumber(final String line, final BatteryJoltage max) {
        final int size = line.length();
        BatteryJoltage localMax = max;
        int currentNumber;
        int i = max.position;

        if (i == -1) {
            i = 0;
        }
        while (i < size) {

            currentNumber = Integer.parseInt(String.valueOf(line.charAt(i)));

            if (i == size - 1) {
                if (max.position != -1 && currentNumber > localMax.joltage && i != max.position) {
                    localMax = new BatteryJoltage(currentNumber, i);
                }
            } else if (currentNumber > localMax.joltage && i != max.position) {
                localMax = new BatteryJoltage(currentNumber, i);
            }

            ++i;
        }

        return localMax;
    }

    private List<String> readFromClasspath() throws Exception {
        final URL resource = getClass().getClassLoader().getResource("day_three/batteries_storage.txt");
        if (resource == null) {
            throw new Exception("ressource null");
        }
        final File file = new File(resource.toURI());

        return Files.readAllLines(file.toPath());
    }

}
