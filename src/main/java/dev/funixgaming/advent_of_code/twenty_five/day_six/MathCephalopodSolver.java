package dev.funixgaming.advent_of_code.twenty_five.day_six;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public final class MathCephalopodSolver {

    private final List<List<String>> numbers = new ArrayList<>();
    private final List<Character> operators = new ArrayList<>();

    public MathCephalopodSolver() throws Exception {

    }

    public long getResult() {

    }

    private List<String> getNumbersInLine(final String line) {
        final List<String> numbers = new ArrayList<>();
        List<Character> stringBuilder = null;

        for (char c : line.toCharArray()) {
            if (c == ' ') {
                if (stringBuilder != null) {
                    stringBuilder = stringBuilder.reversed();
                    numbers.add(

                    )
                    stringBuilder = null;
                }
            } else {
                if (stringBuilder == null) {
                    stringBuilder = new ArrayList<>();
                }
                stringBuilder.add(c);
            }
        }

        if (stringBuilder != null) {
            numbers.add(Long.parseLong(stringBuilder.toString()));
        }
        return numbers;
    }

    private List<String> readFromClasspath() throws Exception {
        final URL resource = getClass().getClassLoader().getResource("day_six/math_problems.txt");
        if (resource == null) {
            throw new Exception("ressource null");
        }
        final File file = new File(resource.toURI());

        return Files.readAllLines(file.toPath());
    }

}
