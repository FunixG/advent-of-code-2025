package dev.funixgaming.advent_of_code.twenty_five.day_one;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

public final class SafeSolver {

    private final List<String> orientations;
    private int dial = 50;

    public SafeSolver() throws Exception {
        this.orientations = this.readFromClasspath();
    }

    public int getPassword() {
        int password = 0;
        int rotation;
        boolean add;

        for (final String orientation : this.orientations) {
            add = orientation.startsWith("R");
            rotation = Integer.parseInt(orientation.substring(1));

            while (rotation > 0) {
                if (add) {
                    this.dial += 1;
                } else {
                    this.dial -= 1;
                }

                if (this.dial > 99) {
                    this.dial = 0;
                } else if (this.dial < 0) {
                    this.dial = 99;
                }

                rotation -= 1;
            }

            if (this.dial == 0) {
                password++;
            }
        }

        return password;
    }

    private List<String> readFromClasspath() throws Exception {
        final URL resource = getClass().getClassLoader().getResource("day_one/safe_rotations.txt");
        if (resource == null) {
            throw new Exception("ressource null");
        }
        final File file = new File(resource.toURI());

        return Files.readAllLines(file.toPath());
    }

}
