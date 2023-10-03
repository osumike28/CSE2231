import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Michael Harper and Elias Baalbaky
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    @Test
    public void tesAddEmpty() {

        Set<String> o = this.createFromArgsTest();
        Set<String> oExpected = this.createFromArgsRef("o");

        o.add("o");

        assertEquals(o, oExpected);
    }

    @Test
    public void testAddLeftTree() {

        //creates instances
        Set<String> o = this.createFromArgsTest("o");
        Set<String> oExpected = this.createFromArgsRef("o", "h");

        // calls method
        o.add("h");

        //compares expected to actual
        assertEquals(o, oExpected);
    }

    @Test
    public void testAddRightCase1() {

        //create instances.
        Set<String> o = this.createFromArgsTest("b", "u", "c");
        Set<String> oExpected = this.createFromArgsRef("b", "u", "c", "k");

        //calls method
        o.add("k");

        //compares expected to actual
        assertEquals(o, oExpected);
    }

    @Test
    public void testAddRightCase2() {
        // Create instances.
        Set<String> o = this.createFromArgsTest("b", "u", "c");
        Set<String> oExpected = this.createFromArgsRef("b", "u", "c", "k");

        // Call method.
        o.add("k");

        // Compare expected to actual.
        assertEquals(o, oExpected);
    }

    @Test
    public void testRemoveToEmptyCase2() {
        // Create instances.
        Set<String> o = this.createFromArgsTest("b");
        Set<String> oExpected = this.createFromArgsRef();

        // Call method.
        String removed = o.remove("b");

        // Compare expected to actual.
        assertEquals(o, oExpected);
        assertEquals(removed, "b");
    }

    @Test
    public void testRemoveRightCase2() {
        // Create instances.
        Set<String> o = this.createFromArgsTest("b", "u", "c", "k");
        Set<String> oExpected = this.createFromArgsRef("b", "u", "k");

        // Call method.
        String removed = o.remove("c");

        // Compare expected to actual.
        assertEquals(o, oExpected);
        assertEquals(removed, "c");
    }

    @Test
    public void testRemoveRightCase3() {

        // Create instances.
        Set<String> o = this.createFromArgsTest("b", "u", "c", "k");
        Set<String> oExpected = this.createFromArgsRef("b", "u", "c");

        // Call method.
        String removed = o.remove("k");

        // Compare expected to actual.
        assertEquals(o, oExpected);
        assertEquals(removed, "k");
    }

    @Test
    public void testRemoveRootEmptyLeftCase4() {

        // Create instances
        Set<String> o = this.createFromArgsTest("b", "u", "c", "k");
        Set<String> oExpected = this.createFromArgsRef("u", "c", "k");

        // Call method.
        String removed = o.remove("b");

        // Compare expected to actual.
        assertEquals(o, oExpected);
        assertEquals(removed, "b");
    }

    @Test
    public void testRemoveRightRootCase5() {
        // Create instances.
        Set<String> o = this.createFromArgsTest("b", "u");
        Set<String> oExpected = this.createFromArgsRef("u");

        // Call method.
        String removed = o.remove("b");

        // Compare expected to actual.
        assertEquals(o, oExpected);
        assertEquals(removed, "b");
    }

    @Test
    public void testRemoveRootNonEmptyLRCase6() {
        // Create instances.
        Set<String> o = this.createFromArgsTest("b", "u", "c", "k");
        Set<String> oExpected = this.createFromArgsRef("u", "c", "k");

        // Call method.
        String removed = o.remove("b");

        // Compare expected to actual.
        assertEquals(o, oExpected);
        assertEquals(removed, "b");
    }

    @Test
    public void testRemoveNonEmptyBothLeftSideCase7() {
        // Create instances.
        Set<String> o = this.createFromArgsTest("b", "u", "c", "k");
        Set<String> oExpected = this.createFromArgsRef("b", "c", "k");

        // Call method.
        String removed = o.remove("u");

        // Compare expected to actual.
        assertEquals(o, oExpected);
        assertEquals(removed, "u");
    }

    @Test
    public void testRemoveNonEmptyBothRightSideCase8() {
        // Create instances.
        Set<String> o = this.createFromArgsTest("b", "u", "c", "k");
        Set<String> oExpected = this.createFromArgsRef("b", "u", "k");

        // Call method.
        String removed = o.remove("c");

        // Compare expected to actual.
        assertEquals(o, oExpected);
        assertEquals(removed, "c");
    }

    @Test
    public void testRemoveAnyToEmptyCase9() {
        // Create instances.
        Set<String> o = this.createFromArgsTest("b");
        Set<String> oExpected = this.createFromArgsRef();

        // Call method.
        String removed = o.removeAny();

        // Compare expected to actual.
        assertEquals(o, oExpected);
        assertEquals(removed, "b");
    }

    @Test
    public void testRemoveAnyNonEmptyCase10() {
        // Create instances.
        Set<String> o = this.createFromArgsTest("b", "u", "c", "k");
        Set<String> oExpected = this.createFromArgsRef("b", "u", "c", "k");

        // Call method.
        String removed = o.removeAny();
        boolean isIn = oExpected.contains(removed);
        oExpected.remove(removed);

        // Compare expected to actual.
        assertEquals(true, isIn);
        assertEquals(o, oExpected);
    }

    @Test
    public void testContainsTrueCase1() {
        // Create instance.
        Set<String> o = this.createFromArgsTest("b");

        // Call method.
        boolean contain = o.contains("b");

        // Compare expected to actual.
        assertEquals(true, contain);
    }

    @Test
    public void testContainsTrueLeftCase2() {
        // Create instance.
        Set<String> o = this.createFromArgsTest("b", "u", "c", "k");

        // Call method.
        boolean contain = o.contains("u");

        // Compare expected to actual.
        assertEquals(true, contain);
    }

    @Test
    public void testContainsTrueRightCase3() {
        // Create instance.
        Set<String> o = this.createFromArgsTest("b", "u", "c", "k");

        // Call method.
        boolean contain = o.contains("c");

        // Compare expected to actual.
        assertEquals(true, contain);
    }

    @Test
    public void testContainsTrueRootCase4() {
        // Create instance.
        Set<String> o = this.createFromArgsTest("b", "u", "c", "k");

        // Call method.
        boolean contain = o.contains("b");

        // Compare expected to actual.
        assertEquals(true, contain);
    }

    @Test
    public void testContainsFalseCase1() {
        // Create instance.
        Set<String> o = this.createFromArgsTest("b");

        // Call method.
        boolean contain = o.contains("w");

        // Compare expected to actual.
        assertEquals(false, contain);
    }

    @Test
    public void testContainsFalseMultiCase2() {
        // Create instance.
        Set<String> o = this.createFromArgsTest("b", "u", "c", "k");

        // Call method.
        boolean contain = o.contains("w");

        // Compare expected to actual.
        assertEquals(false, contain);
    }

    @Test
    public void testSizeEmptyCase1() {
        // Create instance.
        Set<String> o = this.createFromArgsTest();

        // Call method.
        int size = 0;
        int oSize = o.size();

        // Compare expected to actual.
        assertEquals(oSize, size);
    }

    @Test
    public void testSizeSingleCase2() {
        // Create instance.
        Set<String> o = this.createFromArgsTest("b");

        // Call method.
        int size = 1;
        int oSize = o.size();

        // Compare expected to actual.
        assertEquals(oSize, size);
    }

    @Test
    public void testSize3() {
        // Create instance.
        Set<String> o = this.createFromArgsTest("b", "u", "c");

        // Call method.
        int size = 3;
        int oSize = o.size();

        // Compare expected to actual.
        assertEquals(oSize, size);
    }

}
