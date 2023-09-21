import components.map.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class MapTest {

    /**
     * Invokes the appropriate {@code Map} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new map
     * @ensures constructorTest = {}
     */
    protected abstract Map<String, String> constructorTest();

    /**
     * Invokes the appropriate {@code Map} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new map
     * @ensures constructorRef = {}
     */
    protected abstract Map<String, String> constructorRef();

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    private Map<String, String> createFromArgsTest(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorTest();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    private Map<String, String> createFromArgsRef(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorRef();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     * Test No Argument Constructor
     */
    @Test 
    public final void testNoArgumentConstructor() {
        // creates test maps
        Map<String, String> map = this.constructorTest();
        Map<String, String> mapExpected = this.constructorRef();
        
        // test
        assertEquals(map, mapExpected);
    }
    
   /**
    *  Test adding a single pair
    */
    @Test 
    public final void testAddSingle() {
        // creates test maps
        Map<String, String> map = this.constructorTest();
        Map<String, String> mapExpected = this.createFromArgsRef("O,H");
        
        // adds pair to map
        map.add("O", "H");
        
        // test
        assertEquals(map, mapExpected);
        
    }
    
    /**
     * Test adding multiple pairs
     */
    @Test 
    public final void testAddMultiple() {
        // creates test maps
        Map<String, String> map = this.constructorTest();
        Map<String, String> mapExpected = this.createFromArgsRef("O,H","1","O");
        
        //adds pairs to map
        map.add("O", "H");
        map.add("1", "O");
        
        // tests
        assertEquals(map, mapExpected);     
    }
    
    /**
     * Test removing single pair
     */
    @Test 
    public final void testRemoveSingle() {
        // creates test maps 
        Map<String, String> map = this.createFromArgsRef("O,H");
        Map<String, String> mapExpected = this.constructorRef();
        
        // removes pair from map
        map.remove("O");

        // test
        assertEquals(map, mapExpected);  
    }  
    
    /**
     * Test removing any value pair
     */
    @Test
    public final void testRemoveAny() {
        // creates test maps 
        Map<String, String> map = this.createFromArgsTest("O", "H", "1", "O");
        int initialSize = map.size();
        
        // removes pair from map
        map.removeAny();
        
        //tests
        assertEquals(initialSize - 1, map.size());
    }
    
    /**
     * Test removing multiple value pair
     */
    @Test 
    public final void testRemoveMultiple() {
        // creates test maps
        Map<String, String> map = this.createFromArgsTest("O", "H", "1", "O");
        Map<String, String> mapExpected = this.constructorRef();
        
        // removes multiple pairs
        map.remove("O");
        map.remove("1");
        
        // test
        assertEquals(map, mapExpected);     
    }
    
    /**
     * Test retrieving value for key
     */
    @Test
    public final void testValueSingle() {
        // creates test maps
        Map<String, String> m = this.createFromArgsTest("O", "H");
    
        // Expected and retrieved value
        String valueExpected = "H";
        String  value = m.value("O");
        
        
        assertEquals(value, valueExpected);
    }
    
    /**
     * Test if there is a key
     */
    @Test
    public final void testHasKeyTrue() {
        // creates test maps 
        Map<String, String> m = this.createFromArgsTest("O", "H");
        
        //test
        assertTrue(m.hasKey("O"));
    }
    
    /**
     * Tests the size of map
     */
    @Test
    public final void testSizeMultiple() {
        // creates test maps 
        Map<String, String> m = this.createFromArgsTest("O", "H", "I", "O");
        
        // Expected and retrieved value
        int sizeExpected = 2;
        int size= m.size();
        
        // test
        assertEquals(sizeExpected, size);
    }
    
}


