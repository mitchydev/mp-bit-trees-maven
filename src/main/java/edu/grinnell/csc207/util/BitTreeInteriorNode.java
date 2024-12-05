package edu.grinnell.csc207.util;

/**
 * DOCUMENTATION NEEDED.
 *
 * @author Mitch Paiva
 */

public class BitTreeInteriorNode implements BitTreeNode {
    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    BitTreeNode left;
    BitTreeNode right;

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    public BitTreeInteriorNode() {
        this.left = null;
        this.right = null;
    }

    // +---------+-----------------------------------------------------
    // | Methods |
    // +---------+

    public String getVal() {
        throw new UnsupportedOperationException("Interior node does not have a value.");
    }

    /**
     * returns the left value.
     * 
     * @return the left value.
     */
    @Override
    public BitTreeNode getLeft() {
        return this.left;
    }

    /**
     * returns The right value.
     * 
     * @return The right value.
     */
    @Override
    public BitTreeNode getRight() {
        return this.right;
    }

    /**
     * Sets the left node to the node inputted.
     */
    public void setLeft(BitTreeNode leftNode) {
        this.left = leftNode;
    }

    /**
     * Sets the left node to the node inputted.
     */
    public void setRight(BitTreeNode rightNode) {
        this.right = rightNode;
    }

}