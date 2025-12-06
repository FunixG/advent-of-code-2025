package dev.funixgaming.advent_of_code.twenty_five.day_six;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public final class MathSolver {

    private final List<List<Long>> numbers = new ArrayList<>();
    private final List<Character> operators = new ArrayList<>();

    public MathSolver() throws Exception {
        List<Character> operators;

        for (final String line : this.readFromClasspath()) {
            operators = getOperators(line);

            if (!operators.isEmpty()) {
                this.operators.addAll(operators);
            } else {
                this.numbers.add(this.getNumbersInLine(line));
            }
        }
    }

    public long getResult() {
        final int maxRows = this.numbers.size();
        final int maxCols = this.numbers.getFirst().size();
        long result = 0;

        List<Long> numbers;
        char operator;
        Long localNumber;

        for (int x = 0; x < maxCols; ++x) {
            numbers = new ArrayList<>();
            localNumber = null;

            for (int y = 0; y < maxRows; ++y) {
                numbers.add(this.numbers.get(y).get(x));
            }

            operator = this.operators.get(x);
            for (final long number : numbers) {
                if (localNumber == null) {
                    localNumber = number;
                } else if (operator == '+') {
                    localNumber += number;
                } else if (operator == '*') {
                    localNumber *= number;
                }
            }

            if (localNumber != null) {
                result += localNumber;
            }
        }

        return result;
    }

    private List<Long> getNumbersInLine(final String line) {
        final List<Long> numbers = new ArrayList<>();
        StringBuilder stringBuilder = null;

        for (char c : line.toCharArray()) {
            if (c == ' ') {
                if (stringBuilder != null) {
                    numbers.add(Long.parseLong(stringBuilder.toString()));
                    stringBuilder = null;
                }
            } else {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(c);
            }
        }

        if (stringBuilder != null) {
            numbers.add(Long.parseLong(stringBuilder.toString()));
        }
        return numbers;
    }

    static List<Character> getOperators(final String line) {
        final List<Character> operators = new ArrayList<>();

        for (char c : line.toCharArray()) {
            if (c == '+' || c == '*') {
                operators.add(c);
            }
        }

        return operators;
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
