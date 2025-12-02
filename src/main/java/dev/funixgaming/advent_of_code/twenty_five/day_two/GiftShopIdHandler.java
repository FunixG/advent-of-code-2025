package dev.funixgaming.advent_of_code.twenty_five.day_two;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public final class GiftShopIdHandler {

    private final List<ShopRange> rangeIds = new ArrayList<>();
    public boolean partTwo = false;

    public GiftShopIdHandler() throws Exception {
        final String ids = this.readFromClasspath();
        final String[] ranges = ids.split(",");

        String[] rangeSet;
        for (final String range : ranges) {
            rangeSet = range.split("-");

            if (rangeSet.length != 2) continue;

            this.rangeIds.add(new ShopRange(
                    Long.parseLong(rangeSet[0]),
                    Long.parseLong(rangeSet[1])
            ));
        }
    }

    public long getSumOfInvalidIds() {
        long sum = 0;

        long end;
        long current;
        String currentStr;
        int sizeCmp;
        int maxSize;
        int maxLoop;

        String[] parsing;
        String firstPart;
        String secondPart;

        for (final ShopRange shopRange : this.rangeIds) {
            end = shopRange.getEndId();
            current = shopRange.getStartId();

            while (current <= end) {
                currentStr = Long.toString(current);
                maxSize = currentStr.length();

                if (this.partTwo) {
                    sizeCmp = 1;
                    maxLoop = maxSize / 2;

                    while (sizeCmp <= maxLoop) {
                        if (this.foundDuplicateSequence(currentStr, sizeCmp)) {
                            sum += current;
                            break;
                        }

                        ++sizeCmp;
                    }
                } else {
                    sizeCmp = maxSize / 2;

                    parsing = this.getParts(currentStr, sizeCmp);
                    firstPart = parsing[0];
                    secondPart = parsing[1];

                    if (firstPart.equals(secondPart)) {
                        sum += current;
                    }
                }

                ++current;
            }
        }

        return sum;
    }

    private boolean foundDuplicateSequence(final String wholeNumber, final int sequenceSize) {
        final int maxSize = wholeNumber.length();
        final String sequenceInit = wholeNumber.substring(0, sequenceSize);
        String sequence;
        int i = sequenceSize;

        while (i + sequenceSize <= maxSize) {
            sequence = wholeNumber.substring(i, i + sequenceSize);

            if (!sequence.equals(sequenceInit)) {
                return false;
            }
            i += sequenceSize;
        }

        return i == maxSize;
    }

    private String[] getParts(final String currentStr, int size) {
        final String firstPart = currentStr.substring(0, size);
        final String secondPart = currentStr.substring(size);

        return new String[] {
                firstPart,
                secondPart
        };
    }

    private String readFromClasspath() throws Exception {
        final URL resource = getClass().getClassLoader().getResource("day_two/store_ids.txt");
        if (resource == null) {
            throw new Exception("ressource null");
        }
        final File file = new File(resource.toURI());

        return Files.readAllLines(file.toPath()).getFirst();
    }

}
