/*  
 * TCSS 305 Autumn 2022 
 * Assignment 2
 */
package tests;
/** 
 * Test class to test each method from the class ItemOrder. 
 *  
 * @author Christian David 
 * @version 30 Oct 2022 
 */
import static org.junit.jupiter.api.Assertions.*;


import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ItemOrderTest {

    /** Creates an instance field for information in item.*/
    private static Item myItemTest; 
    /** Creates an instance field for information in item order.*/
    private static ItemOrder myItemOrder;
    
    
    /** Makes new objects to fit in information about item and item order. */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        myItemTest = new Item("pencil", new BigDecimal("0.95"));
        myItemOrder = new ItemOrder(myItemTest, 4);
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    } 

    @AfterEach
    void tearDown() throws Exception {
    }
    /**Test the item constructor if a item and quantity can be passed.*/
    @Test
    void testItemOrder() {
        final ItemOrder orderItem = new ItemOrder(myItemTest, 4);
        assertEquals(true, orderItem.getItem().equals(myItemOrder.getItem()) 
                     && orderItem.getQuantity() == myItemOrder.getQuantity()); 
    }
    /**Test item order if it returns a item. */ 
    @Test
    void testGetItem() {
        assertEquals(myItemTest, myItemOrder.getItem());
    }
    /**Test the item order constructor can be null for item.*/
    void testGetItemNull() {
        assertEquals(false, myItemOrder.equals(null));
    }
    /**Test the item order constructor for quantity. */
    @Test
    void testGetQuantity() {
        assertEquals(4 , myItemOrder.getQuantity());
    }
    /**Test the toString method from item order. */
    @Test
    void testToString() {
        assertEquals("Item:pencil, $0.95,the quantity is 4", myItemOrder.toString());
     }
}


