package com.rubdashen.tools.reader;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|
//				    Members and Fields
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|

    //	-------------------------------------------
    //			        Variables
    //	-------------------------------------------
    private @Nullable String mFileContent;

//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|
//			        Functions and Methods
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|

    //	-------------------------------------------
    //			        Constructors
    //	-------------------------------------------
    public FileReader() { }

    //	-------------------------------------------
    //			        Functions
    //	-------------------------------------------
    public boolean readFile(@NotNull String filePath) {
        final Path path = Path.of(filePath);
        try {
            this.mFileContent = Files.readString(path, StandardCharsets.UTF_8);
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }

    //	-------------------------------------------
    //			    Setters and Getters
    //	-------------------------------------------
    public @Nullable String getFileContent() {
        return this.mFileContent;
    }
}
