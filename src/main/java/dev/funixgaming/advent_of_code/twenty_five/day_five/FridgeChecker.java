package dev.funixgaming.advent_of_code.twenty_five.day_five;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class FridgeChecker {

    private final List<FreshIngredient> freshDb = new ArrayList<>();
    private final List<Long> toCheck = new ArrayList<>();

    private final File idsFreshDb = new File("idsFreshDb.txt");

    public boolean partTwo = false;

    public FridgeChecker() throws Exception {
        if (!this.idsFreshDb.createNewFile()) {
            throw new IOException("err create file");
        }

        final List<String> db = this.readFromClasspath();
        boolean listRanges = true;
        String[] range;

        for (final String entry : db) {
            if (entry.isEmpty()) {
                listRanges = false;
                continue;
            }

            if (listRanges) {
                range = entry.split("-");
                if (range.length == 2) {
                    this.freshDb.add(new FreshIngredient(
                            Long.parseLong(range[0]),
                            Long.parseLong(range[1])
                    ));
                }
            } else {
                this.toCheck.add(Long.parseLong(entry));
            }
        }
    }

    public int countFreshIngredients() throws Exception {
        int fresh = 0;

        for (final long entry : this.toCheck) {
            for (final FreshIngredient freshIngredient : this.freshDb) {
                if (freshIngredient.isFresh(entry)) {
                    ++fresh;

                    if (this.partTwo) {
                        for (long i = freshIngredient.startId; i <= freshIngredient.endId; ++i) {
                            this.appendIdToFileDb(i);
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        if (this.partTwo) {
            int lines = Files.readAllLines(this.idsFreshDb.toPath()).size();

            this.idsFreshDb.delete();
            return lines;
        } else {
            this.idsFreshDb.delete();
            return fresh;
        }
    }

    private void appendIdToFileDb(long id) throws Exception {
        if (this.idAlreadyExist(id)) return;

        try (BufferedWriter output = new BufferedWriter(new FileWriter(this.idsFreshDb, true))) {
            output.append(Long.toString(id));
            output.newLine();
        }
    }

    private boolean idAlreadyExist(long id) throws Exception {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(this.idsFreshDb))) {
            while ((line = br.readLine()) != null) {
                if (id == Long.parseLong(line)) {
                    return true;
                }
            }
        }

        return false;
    }

    private List<String> readFromClasspath() throws Exception {
        final URL resource = getClass().getClassLoader().getResource("day_five/fridge_database.txt");
        if (resource == null) {
            throw new Exception("ressource null");
        }
        final File file = new File(resource.toURI());

        return Files.readAllLines(file.toPath());
    }

}
