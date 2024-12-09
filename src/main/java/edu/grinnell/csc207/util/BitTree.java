package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Trees intended to be used in storing mappings between fixed-length
 * sequences of bits and corresponding values.
 *
 * @author Mitch Paiva
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The root.
   */
  private BitTreeNode root;

  /**
   * The height of the tree.
   */
  private int height;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Construct the bit tree.
   *
   * @param n
   */
  public BitTree(int n) {
    this.root = new BitTreeInteriorNode();
    this.height = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * Validates the given bit string against the tree's limitations.
   *
   * @param bits
   */
  public void bitCheck(String bits) {
    if (bits.length() != height) {
      throw new IndexOutOfBoundsException("Bits length invalid.");
    } // if
    for (char ch : bits.toCharArray()) {
      if (ch != '0' && ch != '1') {
        throw new IllegalArgumentException();
      } // if
    } // for
  } // void

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Adds or updates a value in the tree at the specified bit.
   *
   * @param bits
   * @param value
   */
  public void set(String bits, String value) {
    bitCheck(bits);

    BitTreeNode currNode = root;
    for (int i = 0; i < bits.length() - 1; i++) {
      char currBit = bits.charAt(i);

      if (currNode instanceof BitTreeInteriorNode) {
        BitTreeInteriorNode newNode = (BitTreeInteriorNode) currNode;

        switch (currBit) {
          case '0':
            if (newNode.getLeft() == null) {
              newNode.setLeft(new BitTreeInteriorNode());
              currNode = newNode.getLeft();
            } else {
              currNode = newNode.getLeft();
            } // else
            break;
          case '1':
            if (newNode.getRight() == null) {
              newNode.setRight(new BitTreeInteriorNode());
              currNode = newNode.getRight();
            } else {
              currNode = newNode.getRight();
            } // else
            break;
          default:
            throw new IllegalArgumentException();
        } // switch
      } // if
    } // for

    char lastBit = bits.charAt(bits.length() - 1);
    BitTreeInteriorNode finalNode = (BitTreeInteriorNode) currNode;
    if (lastBit == '0') {
      finalNode.setLeft(new BitTreeLeaf(value));
    } else {
      finalNode.setRight(new BitTreeLeaf(value));
    } // else
  } // set(String, String)

  /**
   * Retreives the value stored at the specified bit.
   *
   * @param bits
   *
   * @return string.
   */
  public String get(String bits) {
    bitCheck(bits);

    BitTreeNode currNode = root;
    for (int i = 0; i < bits.length(); i++) {
      char currBit = bits.charAt(i);

      if (currNode instanceof BitTreeInteriorNode) {
        BitTreeInteriorNode newNode = (BitTreeInteriorNode) currNode;

        if (currBit == '0') {
          if (newNode.getLeft() == null) {
            throw new IndexOutOfBoundsException();
          } else {
            currNode = newNode.getLeft();
          } // else
        } else {
          if (newNode.getRight() == null) {
            throw new IndexOutOfBoundsException();
          } else {
            currNode = newNode.getRight();
          } // else
        } // if
      } // for
    } // for
    if (currNode instanceof BitTreeLeaf) {
      return ((BitTreeLeaf) currNode).getVal();
    } else {
      throw new IndexOutOfBoundsException();
    } // else
  } // get

  /**
   * Dumps the tree.
   *
   * @param pen
   */
  public void dump(PrintWriter pen) {
    dumpHelper(this.root, "", pen);
  } // dump(PrintWriter)

  /**
   * Helper to dump the tree.
   *
   * @param node
   * @param path
   * @param pen
   */
  public void dumpHelper(BitTreeNode node, String path, PrintWriter pen) {
    if (node instanceof BitTreeLeaf) {
      pen.println(path + "," + ((BitTreeLeaf) node).getVal());
    } else if (node instanceof BitTreeInteriorNode) {
      BitTreeInteriorNode newNode = (BitTreeInteriorNode) node;
      if (newNode.getLeft() != null) {
        dumpHelper(newNode.getLeft(), path + "0", pen);
      } // if
      if (newNode.getRight() != null) {
        dumpHelper(newNode.right, path + "1", pen);
      } // if
    } // else if
  } // dumpHelper

  /**
   * Loads the bit path and value pairs into the tree.
   *
   * @param source
   */
  public void load(InputStream source) {
    Scanner scanner = new Scanner(source);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] lineParts = line.split(",");
      if (lineParts.length == 2) {
        set(lineParts[0], lineParts[1]);
      } // if
    } // load(InputStream)
  } // load
} // class BitTree
