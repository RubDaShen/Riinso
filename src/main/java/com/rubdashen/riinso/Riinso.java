package com.rubdashen.riinso;

import com.rubdashen.riinso.interpreter.RiinsoInterpreter;
import com.rubdashen.riinso.file.RiinsoFile;
import com.rubdashen.tools.reader.FileReader;
import org.jetbrains.annotations.NotNull;

public final class Riinso {
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|
//				    Members and Fields
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|

    //	-------------------------------------------
    //			        Variables
    //	-------------------------------------------
    private final RiinsoFile mFile = new RiinsoFile();
    private final RiinsoInterpreter mInterpreter = new RiinsoInterpreter();

//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|
//			        Functions and Methods
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|

    //	-------------------------------------------
    //			        Constructors
    //	-------------------------------------------
    public Riinso() { }

    //	-------------------------------------------
    //			        Functions
    //	-------------------------------------------
    public void compile(@NotNull String filePath) {
        final @NotNull String content = this.mFile.readFile(filePath);
        this.mInterpreter.interpret(content);
    }

    //	-------------------------------------------
    //			    Setters and Getters
    //	-------------------------------------------
}
