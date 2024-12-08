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
  public BitTreeNode root;

  /**
   * The height of the tree.
   */
  public int height;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Construct the bit tree.
   */
  public BitTree(int n) {
    this.root = new BitTreeInteriorNode();
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * DOCUMENTATION NEEDED
   */
  public void bitCheck(String bits) {
    if (bits.length() != height) {
      throw new IndexOutOfBoundsException("Bits length invalid.");
    } // if
    for (char ch : bits.toCharArray()) {
      if (ch != 0 && ch != '1') {
        throw new IllegalArgumentException();
      } // if
    } // for
  } // void

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * DOCUMENTATION NEEDED
   */
  public void set(String bits, String value) {
    bitCheck(bits);

    BitTreeNode currNode = root;
    for (int i = 0; i < bits.length(); i++) {
      char currBit = bits.charAt(i);

      if (currNode instanceof BitTreeInteriorNode) {
        BitTreeInteriorNode newNode = (BitTreeInteriorNode) currNode;

        switch (currBit) {
          case '0':
            if (newNode.getLeft() == null) {
              newNode.setLeft(new BitTreeInteriorNode());
            } else {
              currNode = newNode.getLeft();
            }
            break;
          case '1':
            if (newNode.getRight() == null) {
              newNode.setRight(new BitTreeInteriorNode());
            } else {
              currNode = newNode.getRight();
            }
            break;
          default:
            throw new IllegalArgumentException();
        }
      }
    }

    if (currNode instanceof BitTreeLeaf) {
      ((BitTreeLeaf) currNode).value = value;
    } else {
      if (bits.charAt(bits.length() - 1) == '0') {
        ((BitTreeInteriorNode) currNode).setLeft(new BitTreeLeaf(value));
      } else {
        ((BitTreeInteriorNode) currNode).setRight(new BitTreeLeaf(value));
      }
    }
  } // set(String, String)

  /**
   *DOCUMENTATION NEEDED
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
          }
        } else {
          if (newNode.getRight() == null) {
            throw new IndexOutOfBoundsException();
          } else {
            currNode = newNode.getRight();
          }
        }
      }
    }
    if (currNode instanceof BitTreeLeaf) {
      return ((BitTreeLeaf) currNode).getVal();
    } else {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   *DOCUMENTATION NEEDED
   */
  public void dump(PrintWriter pen) {
    dumpHelper(this.root, "", pen);
  } // dump(PrintWriter)

  /**
   * DOCUMENTATION NEEDED
   * @param source
   */
  public void dumpHelper(BitTreeNode node, String path, PrintWriter pen) {
    if (node instanceof BitTreeLeaf) {
      pen.println(path + "," + ((BitTreeLeaf) node).getVal());
    } else if (node instanceof BitTreeInteriorNode) {
      BitTreeInteriorNode newNode = (BitTreeInteriorNode) node;
      if (newNode.getLeft() != null) {
        dumpHelper(newNode.getLeft(), path + "0", pen);
      }
      if (newNode.getRight() != null) {
        dumpHelper(newNode.right, path + "1", pen);
      }
    }
  }

  /**
   * DOCUMENTATION NEEDED
   */
  public void load(InputStream source) {
    Scanner scanner = new Scanner(source);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] lineParts = line.split(",");
      if (lineParts.length == 2) {
        set(lineParts[0], lineParts[1]);
      }
    } // load(InputStream)
  }
} // class BitTree
