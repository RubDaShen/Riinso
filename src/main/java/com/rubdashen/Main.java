package com.rubdashen;

import com.rubdashen.tools.reader.FileReader;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    static final Map<String, Runnable> commands = Map.of(
        "create", Main::runCreateCommand
    );

    private static void runCreateCommand(@NotNull String action) {

    }

    public static void main(String[] args) {
        final FileReader fileReader = new FileReader();

        if (!fileReader.readFile("C:\\Users\\mallm\\Desktop\\Riinso\\assets\\code.rin")) {
            System.out.println("Failed to read the file.");
            return;
        }

        final String content = fileReader.getFileContent();
        System.out.println(content);

        if (content == null) {
            System.out.println("File content is null.");
            return;
        }
        if (content.isEmpty()) {
            System.out.println("File content is empty.");
            return;
        }

        final int size = content.length();

        StringBuilder token = new StringBuilder();
        boolean commandStart = false;
        List<String> tokens = new ArrayList<>();

        for (int i = 0; i < size; ++i) {
            final char currentChar = content.charAt(i);

            if (!commandStart) {
                if (currentChar == '/') {
                    System.out.println("Command start detected...");
                    commandStart = true;
                }

                continue;
            }

            if (currentChar == '\n') {
                tokens.add(token.toString());
                token.setLength(0);

                System.out.println("New line detected, command completed. Processing command...");

                System.out.print("Tokens: ");
                for (String t : tokens) {
                    System.out.println(t + " ");
                }

                for (final String t : tokens) {
                    if (commands.containsKey(t)) {
                        System.out.println("Executing command: " + t);
                        commands.get(t).run();
                    }
                    else {
                        System.out.println("Unknown command: " + t);
                    }
                }

                commandStart = false;
                continue;
            }

            if (currentChar != ' ') {
                token.append(currentChar);
            }
            else {
                tokens.add(token.toString());
                token.setLength(0);
            }
        }
    }
}