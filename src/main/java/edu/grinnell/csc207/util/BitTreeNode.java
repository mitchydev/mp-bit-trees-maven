package edu.grinnell.csc207.util;

/**
 * Represents a node in a BitTree.
 *
 * @author Mitch Paiva
 */
public interface BitTreeNode {

// +--------+------------------------------------------------------
// | Fields |
// +--------+

   /**
   * Returns the character from the leaf.
   *
   * @return the character from the leaf.
   */
  String getVal();

   /**
  * Returns the left value.
 *
 * @return the left value.
  */
  BitTreeNode getLeft();

  /**
  * Returns the right value.
  *
  * @return the right value.
  */
  BitTreeNode getRight();

} // BitTreeNode
