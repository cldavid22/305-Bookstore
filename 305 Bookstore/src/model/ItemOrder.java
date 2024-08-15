/*  
 * TCSS 305 Autumn 2022 
 * Assignment 2
 */
package model;
/** 
 * 
 * Makes an ItemOrder class to create 
 * objects that stores the item and 
 * quantity when item purchased. 
 *  
 * @author Christian David 
 * @version 30 Oct 2022 
 */


public final class ItemOrder {

    /** Creates an instance field for item.*/
    private final Item myItem; 

    /** Creates an instance field for item quantity.*/
    private final int myQuantity;

    /** 
     * 
     * Creates constructor that takes item 
     * and the item quantity.
     * 
     * @param theItem gets the item of the order.
     * @param theQuantity gets the quantity of the order.
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        if (theItem == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (theQuantity < 0) {
            throw new IllegalArgumentException("quantity passed in itemorder "
                                 + "constructor was less than 0" + theQuantity);
                                                
        }
        myQuantity = theQuantity; 
        myItem = theItem;
    }

    /** 
     * Creates a method to return the item order.
     * @return the item order.
     */
    public Item getItem() {
        return myItem;
    }
    
    /** 
     * Creates a method to return the quantity of that item.
     * @return the item quantity.
     */
    public int getQuantity() {

        return  myQuantity;
    }

    /**
     * Creates a toString method to display item and its
     * quantity. 
     * 
     * @return the item and its quantity.
     */
    @Override
    public String toString() {

        return "Item:" + myItem + ",the quantity is" + " " + myQuantity;
    }

}


