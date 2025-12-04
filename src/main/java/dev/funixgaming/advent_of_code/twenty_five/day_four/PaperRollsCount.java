package dev.funixgaming.advent_of_code.twenty_five.day_four;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public final class PaperRollsCount {

    private final List<String> map;

    public int maxForksToPutLift = 4;
    public char paperRoll = '@';
    public boolean removeAll = false;

    final List<Axis> forklifts = new ArrayList<>();

    public PaperRollsCount() throws Exception {
        this.map = readFromClasspath();
    }

    public int countForklifts() {
        final int rows = map.size();
        final int lineSize = map.getFirst().length();
        final Axis[] axisChecks = {
                new Axis(1, 0),
                new Axis(-1, 0),
                new Axis(0, 1),
                new Axis(0, -1),
                new Axis(1, 1),
                new Axis(-1, -1),
                new Axis(-1, 1),
                new Axis(1, -1)
        };

        final List<Axis> localForklifts = new ArrayList<>();
        int currentPaperRolls;

        for (int y = 0; y < rows; ++y) {
            for (int x = 0; x < lineSize; ++x) {
                currentPaperRolls = 0;

                if (!this.getPaperRollAtCoordinates(x, y, 0, 0, rows, lineSize)) continue;

                for (final Axis axis : axisChecks) {
                    if (this.getPaperRollAtCoordinates(x, y, axis.xAxis, axis.yAxis, rows, lineSize)) {
                        ++currentPaperRolls;
                    }
                }

                if (currentPaperRolls < this.maxForksToPutLift) {
                    localForklifts.add(new Axis(x, y));
                }
            }
        }

        if (this.removeAll) {
            if (localForklifts.isEmpty()) {
                return this.forklifts.size();
            } else {
                this.forklifts.addAll(localForklifts);
                return countForklifts();
            }
        } else {
            return localForklifts.size();
        }
    }

    private boolean getPaperRollAtCoordinates(final int corX, final int corY, final int xAxis, final int yAxis, final int maxRows, final int maxLen) {
        final int x = corX + xAxis;
        final int y = corY + yAxis;

        if (x < 0 || y < 0 || x >= maxLen || y >= maxRows) return false;

        if (this.checkForkliftLatLng(x, y)) {
            return false;
        }

        final String line = this.map.get(y);
        if (line == null) return false;

        return line.charAt(x) == this.paperRoll;
    }

    private boolean checkForkliftLatLng(final int x, final int y) {
        for (final Axis axis : this.forklifts) {
            if (axis.xAxis == x && axis.yAxis == y) {
                return true;
            }
        }

        return false;
    }

    private List<String> readFromClasspath() throws Exception {
        final URL resource = getClass().getClassLoader().getResource("day_four/rolls_paper.txt");
        if (resource == null) {
            throw new Exception("ressource null");
        }
        final File file = new File(resource.toURI());

        return Files.readAllLines(file.toPath());
    }

    private boolean _debugTestLatLng(final int x, final int y, final List<Axis> axes) {
        for (final Axis axis : axes) {
            if (axis.yAxis == y && axis.xAxis == x) {
                return true;
            }
        }

        return false;
    }

}
