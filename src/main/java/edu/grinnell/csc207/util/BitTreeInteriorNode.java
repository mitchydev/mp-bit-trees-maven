package edu.grinnell.csc207.util;

/**
 * Represents an interior node in a BitTree.
 *
 * @author Mitch Paiva
 */

public class BitTreeInteriorNode implements BitTreeNode {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
  * Left.
  * */
  BitTreeNode left;

  /**
  * Right.
  * */
  BitTreeNode right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Initializes an interior node.
   *
   * @author Mitch Paiva
   */
  public BitTreeInteriorNode() {
    this.left = null;
    this.right = null;
  } // BitTreeInteriorNode

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Unsupported.
   *
   * @return String
   */
  public String getVal() {
    throw new UnsupportedOperationException("Interior node does not have a value.");
  } // getVal

  /**
   * returns the left value.
   *
   * @return the left value.
   */
  @Override
  public BitTreeNode getLeft() {
    return this.left;
  } // getLeft

  /**
   * returns The right value.
   *
   * @return The right value.
   */
  @Override
  public BitTreeNode getRight() {
    return this.right;
  } // getRight

  /**
   * Sets the left node to the node inputted.
   *
   * @param leftNode
   */
  public void setLeft(BitTreeNode leftNode) {
    this.left = leftNode;
  } // setLeft

  /**
   * Sets the left node to the node inputted.
   *
   * @param rightNode
   */
  public void setRight(BitTreeNode rightNode) {
    this.right = rightNode;
  } // setRight

} // BitTreeInteriorNode
