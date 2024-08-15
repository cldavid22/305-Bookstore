/*  
 * TCSS 305 Autumn 2022 
 * Assignment 2
 */
package tests;
/** 
 * Test class to test each method from the class item. 
 *  
 * @author Christian David 
 * @version 30 Oct 2022 
 */
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import model.Item;

import org.junit.jupiter.api.AfterAll;  
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




class ItemTest {

    /** Creates an instance field for the information of item for the name and price.*/
    private Item myTestItem;
    /** Creates an instance field for the information of item for the name,price,
     * bulk quantity/price. 
     */
    private Item myTestItems;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    /** Makes new objects to fit in information about item . */
    void setUp() throws Exception {
        myTestItem = new Item("pencil", new BigDecimal("0.95")); 
        myTestItems = new Item("Pencil", new BigDecimal("2.00"),
                               3, new BigDecimal("4.50"));
    }

    @AfterEach
    void tearDown() throws Exception {
    }
    /**Test the item constructor if a name can be passed. */
    @Test
    void testGetItemName() {
        assertEquals("pencil", myTestItem.getItemName()); 
    }
    /**Test the item constructor can be null for name. */
    @Test
    void testGetItemNameNull() {
        assertEquals(false, myTestItem.equals(null));
    }
    /**Test if a HashCode value can be passed with name and price. */
    @Test
    void testHashCode() {
        final Item testhash = new Item("pencil", new BigDecimal("0.95"));
    }
    /**Test the item constructor if a price can be passed. */
    @Test
    void testGetPrice() {
        assertEquals(new BigDecimal("0.95"), myTestItem.getPrice()); 
    }
    /**Test the item constructor can be null for price. */
    @Test
    void testGetPriceNull() {
        assertEquals(false, myTestItem.equals(null));
    }
    /**Test the item constructor if a bulk quantity can be passed. */
    @Test
    void testGetBulkQuantity() {
        assertEquals(3, myTestItems.getBulkQuantity());
    }
    /**Test the item constructor can be null for bulk quantity. */
    @Test
    void testGetBulkQuantityNull() {
        assertEquals(false, myTestItems.equals(null));
    }
    /**Test the item constructor if a bulk price can be passed. */
    @Test
    void testGetBulkPrice() {
        assertEquals(new BigDecimal("4.50"), myTestItems.getBulkPrice());
    }
    /**Test the item constructor can be null for bulk price. */
    @Test
    void testGetBulkPriceNull() {
        assertEquals(false, myTestItems.equals(null));
    }
    /**Test the bulk quantity if its nonnegative. */
    @Test
    void testIsBulk() {
        assertEquals(false, myTestItems.equals("Bulk quantity was not greater than 0"));
    }
    /**Test the toString method from item class. */
    @Test
    void testToString() {
        final Item teststring = new Item("Pencil", new BigDecimal("2.00"),
                                        3, new BigDecimal("4.50"));
        assertEquals("Pencil, $2.00 (3 for $4.50)", teststring.toString());
    }
    /**Test if objects are equal to each other from items. */
    @Test
    void testEqualsObject() {
        assertEquals(false, myTestItem.equals("Objects are not the same"));
    }
    /**Test if objects are null. */
    @Test
    void testEqualsObjectNull() {
        assertEquals(false, myTestItem.equals(null));
    }

}
