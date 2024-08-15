/*  
 * TCSS 305 Autumn 2022 
 * Assignment 2
 */
package tests;
/** 
 * Test class to test each method from the class cart. 
 *  
 * @author Christian David 
 * @version 30 Oct 2022 
 */
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Cart;
import model.Item;
import model.ItemOrder;



class CartTest {

    /** Creates an instance field for information in item.*/
    private static Item myItemTest; 
    /** Creates an instance field for information in item order.*/
    private static ItemOrder myItemOrder;
    /** Creates an second instance field for information in item.*/
    private static Item myItemTests; 
    /** Creates an second instance field for information in item order.*/
    private static ItemOrder myItemOrders;

    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    /** Makes new objects to fit in information about item and item order . */
    @BeforeEach
    void setUp() throws Exception {  
        myItemTest = new Item("pencil", new BigDecimal("0.95"));
        myItemOrder = new ItemOrder(myItemTest, 4);
        myItemTests = new Item("pencil 2", new BigDecimal("4"));
        myItemOrders = new ItemOrder(myItemTests, 5);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    /**Test cart constructor if item information can be passed. */ 
    @Test
    void testCart() {
        final Cart shoppingCart = new Cart();
        shoppingCart.add(myItemOrder);
        assertEquals(1, shoppingCart.getCartSize());
    }
    
    /**Test cart replaces new item order. */ 
    @Test
    void testAdd() {
        final Cart shoppingCart = new Cart();
        shoppingCart.add(myItemOrder);
        assertEquals(1, shoppingCart.getCartSize());
    }
    
    /**Test if membership can be false. */ 
    @Test
    void testSetMembership() {
        final Cart shoppingCart = new Cart();
        assertEquals(false, shoppingCart.equals(null));
    }
    /**Test calculating total based on item information. */ 
    @Test
    void testCalculateTotal() {
        final Cart shoppingCart = new Cart();
        shoppingCart.add(myItemOrder);
        shoppingCart.setMembership(false);
        assertEquals(new BigDecimal("3.80") , shoppingCart.calculateTotal());
    }
    /**Test calculating total with bulk based on item information. */ 
    @Test
    void testCalculateTotalWithBulk() {
        final Cart shoppingCart = new Cart();
        shoppingCart.add(myItemOrder);
        shoppingCart.add(myItemOrders);
        shoppingCart.setMembership(true);
        assertEquals(new BigDecimal("23.80") , shoppingCart.calculateTotal());
    }
    
    /**Test if cart can be cleared. */
    @Test
    void testClear() {
        final Cart shoppingCart = new Cart();
        shoppingCart.add(myItemOrder);
        shoppingCart.clear();
        assertEquals(0 , shoppingCart.getCartSize());
    }
    /**Test the size of cart.*/
    @Test 
    void testGetCartSize() {
        final Cart shoppingCart = new Cart();
        shoppingCart.add(myItemOrder);
        assertEquals(1 , shoppingCart.getCartSize());
    }
    
    /**Test the toString method from cart class. */
    @Test
    void testToString() {
        final Cart shoppingCart = new Cart();
        shoppingCart.add(myItemOrder);
        assertEquals("{pencil, $0.95=Item:pencil, $0.95,"
                    + "the quantity is 4}", shoppingCart.toString());
    }

}
