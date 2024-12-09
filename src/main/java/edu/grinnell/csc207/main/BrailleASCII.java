package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BrailleAsciiTables;
import java.io.PrintStream;

/**
 * A command-line interface for converting braille.
 *
 * @author Mitch Paiva
 */
public class BrailleASCII {
  /**
   * A command-line interface for converting braille.
   *
   * @param args
   */
  public static void main(String[] args) {
    PrintStream output = System.out;
    if (args.length < 2) {
      output.println("Wrong input length.");
      return;
    } // if

    String input1 = args[0].toLowerCase();
    String input2 = args[1];

    try {
      switch (input1) {
        case "braille":
          StringBuilder braille = new StringBuilder();
          for (int i = 0; i < input2.length(); i++) {
            String bits = BrailleAsciiTables.toBraille((input2.charAt(i)));
            if (bits.isEmpty()) {
              output.println("Trouble translating because No corresponding value");
              return;
            } // if
            braille.append(bits);
          } // for
          output.println(braille.toString());
          break;
        case "ascii":
          if (input2.length() % 6 != 0) {
            output.println("Invalid length of bit string");
            return;
          } // if
          StringBuilder asciiResult = new StringBuilder();
          for (int i = 0; i < input2.length(); i += 6) {
            String part = input2.substring(i, i + 6);
            asciiResult.append(BrailleAsciiTables.toAscii(part));
          } // if
          output.println(asciiResult.toString());
          break;
        case "unicode":
          StringBuilder unicode = new StringBuilder();
          for (int i = 0; i < input2.length(); i++) {
            String bits = BrailleAsciiTables.toBraille(input2.charAt(i));
            String hex = BrailleAsciiTables.toUnicode(bits);
            int cp = Integer.parseInt(hex, 16);
            char unicodeChars = (char) cp;
            unicode.append(unicodeChars);
          } // for
          output.println(unicode.toString());
          break;
        default:
          System.err.println("Invalid entry.");
      } // BrailleASCII
    } catch (Exception e) {
        e.printStackTrace();
    } // catch
  } // main
} // BrailleAscii
