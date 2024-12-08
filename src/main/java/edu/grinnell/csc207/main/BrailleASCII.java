package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BrailleAsciiTables;

public class BrailleASCII {
    public static void main (String[] args) {
        if (args.length < 2) {
            System.out.println("Wrong input length.");
            return;
        }

        System.out.println("Input1: " + args[0]);
        System.out.println("Input2: " + args[1]);
        String input1 = args[0].toLowerCase();
        String input2 = args[1];

        try {
            switch (input1) {
            case "braille":
                StringBuilder braille = new StringBuilder();
                for (int i = 0; i < input2.length(); i++) {
                    braille.append(BrailleAsciiTables.toBraille(input2.charAt(i)));
                }
                System.out.println(braille.toString());
                break;
            case "ascii":
                System.out.println(BrailleAsciiTables.toAscii(input2));
                break;
            case "unicode":
                System.out.println(BrailleAsciiTables.toUnicode(input2));
                break;
            default:
                System.err.println("Invalid entry.");
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}