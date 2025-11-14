package com.rubdashen.riinso.interpreter;

import com.rubdashen.tools.text.formater.TextFormatter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public final class RiinsoInterpreter {
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|
//				    Members and Fields
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|

    //	-------------------------------------------
    //			        Variables
    //	-------------------------------------------
    private Boolean mCommandStart = false;

    private final StringBuilder mToken = new StringBuilder();
    private final ArrayList<String> mTokens = new ArrayList<>();

//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|
//			        Functions and Methods
//	|-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-|

    //	-------------------------------------------
    //			        Constructors
    //	-------------------------------------------
    public RiinsoInterpreter() { }

    //	-------------------------------------------
    //			        Functions
    //	-------------------------------------------
    public void interpret(@NotNull String content) {
        final int size = content.length();

        for (int i = 0; i < size; ++i) {
            final char currentChar = content.charAt(i);

            if (!this.mCommandStart) {
                if (currentChar == '/') {
                    System.out.println("Command start detected...");
                    this.mCommandStart = true;
                }

                continue;
            }

            if (currentChar == '\n') {
                this.mTokens.add(mToken.toString());
                mToken.setLength(0);

                System.out.println("New line detected, command completed. Processing command...");

                System.out.print("Tokens: ");
                for (String t : this.mTokens) {
                    System.out.println(t + " ");
                }

                for (int k = 0; k < this.mTokens.size(); ++k) {
                    String currentToken = this.mTokens.get(k);
                    switch (currentToken) {
                        case "create" -> {
                            System.out.println("User wants to create a variable.");
                            String createVariableType = this.mTokens.get(k + 1);
                            switch (createVariableType) {
                                case "value" -> {
                                    System.out.println("User decided to use a value type.");
                                    String variableName = this.mTokens.get(k + 2);
                                    System.out.println("Value type name is \"" + variableName + "\"");

                                    String variableValue = this.mTokens.get(k + 3);
                                    System.out.println("Value type value is \"" + variableValue + "\"");

                                    String variableDecorator = this.mTokens.get(k + 4);
                                    switch (variableDecorator) {
                                        case "as" -> {
                                            System.out.println("User wants to decorate the variable as a specific type.");
                                            String dataType = TextFormatter.cleanString(this.mTokens.get(k + 5));
                                            switch (dataType) {
                                                case "int" -> {
                                                    System.out.println("User decided to use an int type.");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                this.mCommandStart = false;
                continue;
            }

            if (currentChar != ' ') {
                mToken.append(currentChar);
            }
            else {
                mTokens.add(mToken.toString());
                mToken.setLength(0);
            }
        }
    }

    //	-------------------------------------------
    //			    Setters and Getters
    //	-------------------------------------------
}
