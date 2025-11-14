package com.rubdashen.riinso.file;

import com.rubdashen.tools.reader.FileReader;
import org.jetbrains.annotations.NotNull;

public final class RiinsoFile {
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|
//				    Members and Fields
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|

    //	-------------------------------------------
    //			        Variables
    //	-------------------------------------------
    public final FileReader mFileReader = new FileReader();

//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|
//			        Functions and Methods
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|

    //	-------------------------------------------
    //			        Constructors
    //	-------------------------------------------
    public RiinsoFile() { }

    //	-------------------------------------------
    //			        Functions
    //	-------------------------------------------
    public @NotNull String readFile(@NotNull String filePath) {
        if (!this.mFileReader.readFile(filePath)) {
            throw new RuntimeException("Error reading file with path: " + filePath);
        }

        final @NotNull String content = this.mFileReader.getFileContent();

        if (content.isEmpty()) {
            throw new RuntimeException("File content is empty for file with path: " + filePath);
        }

        System.out.println(content);

        return content;
    }

    //	-------------------------------------------
    //			    Setters and Getters
    //	-------------------------------------------
}
