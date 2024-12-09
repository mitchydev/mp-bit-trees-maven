package edu.grinnell.csc207.util;

/**
 * Represents a leaf in a bit tree.
 *
 * @author Mitch Paiva
 */
public class BitTreeLeaf implements BitTreeNode {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
  * Value.
  * */
  private String value;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Initializes a leaf node.
   *
   * @param value
   */
  public BitTreeLeaf(String value) {
    this.value = value;
  } // BitTreeLeaf

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Returns the character from the leaf.
   *
   * @return the character from the leaf.
   */
  @Override
  public String getVal() {
    return this.value;
  } // getVal

  /**
   * Returns the left value.
   *
   * @return An exception (the left leaf does not have a value).
   */
  @Override
  public BitTreeNode getLeft() {
    throw new UnsupportedOperationException("Leaf does not have a left child!'");
  } // getLeft

  /**
   * Returns the right child's value.
   *
   * @return An exception (the right leaf does not have a value).
   */
  @Override
  public BitTreeNode getRight() {
    throw new UnsupportedOperationException("Leaf does not have a right child!");
  } // getRight

} // BitTreeLeaf
