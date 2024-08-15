/*  
 * TCSS 305 Autumn 2022 
 * Assignment 2
 */
package model;
/** 
 * 
 * Makes an Item class to create 
 * objects that stores the name
 * price, bulk quantity/price
 * of that item.
 *  
 * @author Christian David 
 * @version 30 October 2022 
 */
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;


public final class Item {

    /** Creates an instance field for name.*/
    private final String myName;
    /** Creates an instance field for price.*/
    private final BigDecimal myPrice;
    /** Creates an instance field for bulk quantity.*/
    private int myBulkQuantity;
    /** Creates an instance field for bulk price.*/
    private BigDecimal myBulkPrice;


    /** 
     * 
     * Creates constructor that takes the name of item 
     * and the price.
     * 
     * @param theName the name of the item.
     * @param thePrice the price of the item.
     */
    public Item(final String theName, final BigDecimal thePrice) {
        if (theName == null) {
            throw new IllegalArgumentException("name passed to Item constructor was null");
        }
        if (thePrice == null) {
            throw new IllegalArgumentException("price passed to Item constructor was null");
        }
        myName = theName;
        myPrice = thePrice;
    } 

    
    /** 
     * 
     * Creates constructor that takes the name of item, the price,
     * the amount in bulk quantity and the bulk price for that
     * quantity.
     *
     * 
     * @param theName the name of the item.
     * @param thePrice the price of the item.
     * @param theBulkQuantity the bulk quantity for item.
     * @param theBulkPrice the bulk price of the item.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {

        this(theName , thePrice); 

        if (theBulkQuantity < 0) {
            throw new IllegalArgumentException("bulk quantity passed to constructor" 
                                              + "was less than 0" + theBulkQuantity);
        }
        if (theBulkPrice == null || theBulkPrice.doubleValue() < 0) {
            throw new IllegalArgumentException("bulk price passed to constructor"
                                              + " was less than 0" + theBulkPrice);
        }
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = theBulkPrice;  
    }
    
    /** 
     * Creates a method to return the item name.
     * @return the name of the item.
     */
    public String getItemName() {
        
        return myName;
    }
    /** 
     * Creates a method to return the item price.
     * @return the price of the item.
     */
    public BigDecimal getPrice() {
        
        return myPrice; 
    }

    /** 
     * Creates a method to return the item bulk quantity.
     * @return the bulk quantity of the item.
     */
    public int getBulkQuantity() {

        return myBulkQuantity;
    }
 
    /** 
     * Creates a method to return the item bulk price.
     * @return the bulk price of the item.
     */
    public BigDecimal getBulkPrice() {

        return myBulkPrice;
    }

    /** 
     * Creates a method to return if item is in bulk.
     * @return the boolean value if it is bulk.
     */
    public boolean isBulk() {

        return myBulkQuantity > 0;
    }

    /**
     * Creates a toString method to make a string builder
     * to call the name, price, bulk quantity and bulk 
     * price of the item. 
     * 
     * @return the name, price, bulk quantity/price in a string.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(myName);
        final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        sb.append(", ");
        sb.append(nf.format(myPrice.doubleValue()));
        if (myBulkQuantity > 0) {
            sb.append(" (");
            sb.append(myBulkQuantity);
            sb.append(" for ");
            sb.append(nf.format(myBulkPrice.doubleValue()));
            sb.append(")");
        }
        return sb.toString();
    }

    
    /**
     * Creates a equals method to see if 
     * two object of the item passed is
     * equivalent.
     *  
     * @return if the Item is equivalent 
     */
    @Override
    public boolean equals(final Object theOther) {
        if (theOther == null || !getClass().equals(theOther.getClass())) {
            return false;
        }
        final Item otherItem = (Item) theOther;

        return myName.equalsIgnoreCase(otherItem.myName)  
                   &&  myPrice.equals(otherItem.myPrice);
    }

    /**
     * Creates a hash code method 
     * to return the hash code for that
     * item.
     *  
     * @return the hash code for the item name and price. 
     */
    @Override
    public int hashCode() {

        return Objects.hash(myName, myPrice);
    }

}
