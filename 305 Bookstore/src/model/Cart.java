/*  
 * TCSS 305 Autumn 2022 
 * Assignment 2
 */
package model;
/** 
 * 
 * Makes cart class to collect all items stored
 * then get the price and replace other items onto it.
 *  
 * @author Christian David 
 * @version 30 Oct 2022 
 */
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class Cart {
   
    /** Creates an instance field for membership.*/
    private boolean myMembership;    
 
    /** Creates an instance field of a map.*/
    private final Map<Item, ItemOrder> myCart;
   
    /** Empty constructor to initialize an hash map. */
    public Cart() { 
        myCart = new HashMap<>();
        myMembership = false; 
    }
    
    /**
     *  Finds the different in quantity between two exact items and if one
     * greater than it will replace it.
     *  
     *@param theOrder is order replacing the item in the index.
     */
    public void add(final ItemOrder theOrder) {
        myCart.put(theOrder.getItem(), theOrder); 
    }
    
    /** 
     * Setting Boolean value if they are a member.
     *@param theMembership determining if they are a member. 
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }
    
    /** 
     * calculates total cost for all items in cart and considers
     * items in bulk.
     * 
     * @return the orderPrice
     */
    public BigDecimal calculateTotal() {
        BigDecimal orderPrice  = BigDecimal.ZERO;
        for (final ItemOrder p: myCart.values()) {
            if (p.getItem().isBulk()) {
                final int leftoverstotal = p.getQuantity() % p.getItem().getBulkQuantity();
                orderPrice = orderPrice.add(new BigDecimal(leftoverstotal).multiply
                                            (p.getItem().getPrice()));
                final BigDecimal leftovers = new BigDecimal(p.getQuantity() - leftoverstotal);
                BigDecimal priceleftover = p.getItem().getPrice().multiply(leftovers);
                if (myMembership) {
                    priceleftover = p.getItem().getBulkPrice().multiply
                         (new BigDecimal(p.getQuantity() / p.getItem().getBulkQuantity()));
                }
                orderPrice = orderPrice.add(priceleftover);
            
            } else {
                final BigDecimal nonbulktotal = p.getItem().getPrice().multiply
                            (new BigDecimal(p.getQuantity()));
                orderPrice = orderPrice.add(nonbulktotal);         
            }
        
        }
        return orderPrice;

    }
   /**
    * Clears the cart from map.
    * 
    */
    public void clear() {
        myCart.clear();
    }
    /**
     * Gets size of cart from map.
     * @return cart size.
     */
    public int getCartSize() {
        return myCart.size(); 
    }


    /**
     * Creates a toString method to make a string builder
     * to call the cart.
     * 
     * @return cart 
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(myCart);
        return sb.toString();
    }

}

