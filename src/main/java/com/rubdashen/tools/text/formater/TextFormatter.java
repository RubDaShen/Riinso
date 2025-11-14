package com.rubdashen.tools.text.formater;

import org.jetbrains.annotations.NotNull;

public class TextFormatter {
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|
//			        Functions and Methods
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|

    //	-------------------------------------------
    //			        Functions
    //	-------------------------------------------
    public static @NotNull String cleanString(@NotNull String input) {
        return input.replace("\n", "").replace("\r", "").replace("\t", "").trim();
    }
}
