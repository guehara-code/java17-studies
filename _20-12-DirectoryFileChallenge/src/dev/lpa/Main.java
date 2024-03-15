package dev.lpa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Path deepestFolder = Path.of("public", "assets", "icons");

        try {
            Files.createDirectories(deepestFolder);
            generateIndexFile(deepestFolder.getName(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void generateIndexFile(Path startingPath) throws IOException {
        Path indexFile = startingPath.resolve("index.txt");
        try (Stream<Path> contents = Files.find(startingPath, Integer.MAX_VALUE,
                (path, attr) -> true)) {
            String fileContents = contents
                    .map((path) -> path.toAbsolutePath().toString())
                    .collect(Collectors.joining(
                            System.lineSeparator(),
                            "Directory Contents: " + System.lineSeparator(),
                            System.lineSeparator() + "Generated: " + LocalDateTime.now()
                    ));
            Files.writeString(indexFile, fileContents, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
