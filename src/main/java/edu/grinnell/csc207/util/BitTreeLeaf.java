package edu.grinnell.csc207.util;

/**
 * DOCUMENTATION NEEDED.
 *
 * @author Mitch Paiva
 */
public class BitTreeLeaf implements BitTreeNode {
    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+
    public String value;

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+
    public BitTreeLeaf() {
        this.value = null;
    }

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
    }

    /**
     * Returns the left value.
     * 
     * @return An exception (the left leaf does not have a value).
     */
    @Override
    public BitTreeNode getLeft() {
        throw new UnsupportedOperationException("Leaf does not have a left child!'");
    }

    /**
     * returns the right child's value.
     * 
     * @return An exception (the right leaf does not have a value).
     */
    @Override
    public BitTreeNode getRight() {
        throw new UnsupportedOperationException("Leaf does not have a right child!");
    }

}