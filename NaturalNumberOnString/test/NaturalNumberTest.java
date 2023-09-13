import components.naturalnumber.NaturalNumber;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Michael Harper and Elias Baalbaky
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    // TODO - add test cases for four constructors, multiplyBy10, divideBy10, isZero
    /**
     * Testing constructor with empty argument.
     * 
     * @Challenging empty entry
     */
    @Test
    public void testConstructor() {
        NaturalNumber n = this.constructorTest();
        NaturalNumber nExpected = this.constructorRef();
        assertEquals(nExpected, n);
    }

    /**
     * Testing constructor with a String
     * 
     * @Boundary
     */
    
    @Test
    public void testConstructorWithString() {
        NaturalNumber n = this.constructorTest("1");
        NaturalNumber nExpected = this.constructorRef("1");
        assertEquals(nExpected, n);
    }

    /**
     * Testing constructor with an argument that is String containing value "7"
     * 
     * @Routine
     */
    @Test
    public void testConstructorWithStrings() {
        NaturalNumber n = this.constructorTest("7");
        NaturalNumber nExpected = this.constructorRef();
        assertEquals(nExpected, n);
    }

    /**
     * Testing constructor with int.
     * 
     * @Boundary
     */
    @Test
    public void testConstructorWithInt() {
        NaturalNumber n = this.constructorTest(1);
        NaturalNumber nExpected = this.constructorRef(1);
        assertEquals(nExpected, n);
    }
   
   /**
    * Test constructor with multiple 0s
    * 
    * @Challenging
    */
   @Test
    public void testConstructorWithInt00000() {
        NaturalNumber n = this.constructorTest(00000);
        NaturalNumber nExpected = this.constructorRef();
        assertEquals(nExpected, n);
    }

   /**
    * Test constructor with max int value.
    * 
    * @Boundary
    */
   @Test
   public void testConstructorWithMaxInt() {
        NaturalNumber n = this.constructorTest(Integer.MAX_VALUE);
        NaturalNumber nExpected = this.constructorRef(Integer.MAX_VALUE);
        assertEquals(nExpected, n);
    }

   /**
    * Test natural number constructor with 0
    * 
    * @Boundary
    */
   @Test
   public void testConstructorWithNaturalNumber0() {
    NaturalNumber n = this.constructorTest(0);
    NaturalNumber n2 = this.constructorRef(n);
    NaturalNumber nExpected = this.constructorRef(0);
    assertEquals(nExpected, n2);
   }

   /**
    * Testing multipyBy10 with NN 0 and k equal to 0
    * 
    * @Boundary
    */
   @Test
   public void testEmptyMultiplyBy10() {
    NaturalNumber n = this.constructorTest();
    NaturalNumber nExpected = this.constructorRef(0);
    n.multiplyBy10(0);
    assertEquals(nExpected, n);
   }

   /**
    * Testing multiplyBy10 with empty test constructor
    * 
    * @Routine
    */
   @Test
   public void testEmptyMultiplyBy10WithString() {
    NaturalNumber n = this.constructorTest();
    NaturalNumber nExpected = this.constructorRef("1");
    n.multiplyBy10(1);
    assertEquals(nExpected, n);
   }

   /**
    * Testing multiplyBy10 with an iterative method
    * 
    * @Challenging
    */
   @Test
   public void testMultiplyBy10WithLoop() {
    NaturalNumber n = this.constructorTest();
    NaturalNumber nExpected = this.constructorRef("1111");
    int i = 1;
    while(n.compareTo(nExpected) != 0) {
        if(i<10) {
            n.multiplyBy10(i);
            i++;
        } else {
            n.multiplyBy10(0);
        }
    }

    assertEquals(nExpected, n);

   }

   /**
    * Testing divideBy10 with natural number with 1 digit
    * 
    * @Routine
    */
   @Test
   public void testDivideBy10WithInt() {
    NaturalNumber n = this.constructorTest(8);
    NaturalNumber nExpected = this, constructorRef();
    int d = n.divideBy10();
    int dExpected = 8;

    assertEquals(dExpected, d);
    assertEquals(nExpected, n);
   }

   /**
    * Testing divideBy10 with NN 0 and k equal to 0
    * 
    * Boundary
    */
   @Test
   public void testEmptyDivideBy10() {
    NaturalNumber n = this.constructorTest();
    NaturalNumber nExpected = this, constructorRef();
    int d = n.divideBy10();
    int dExpected = 0;

    assertEquals(dExpected, d);
    assertEquals(nExpected, n);
   }

   /**
    * Testing empty nn with multiplyBy10 then divideBy10
    * 
    * @Challenging
    */
   @Test
   public void testMultiplyThenDivide() {
    NaturalNumber n = this.constructorTest();
    NaturalNumber nExpected = this.constructorRef(0);
    n.multiplyBy10(0);
    n.divideBy10(0);
    assertEquals(nExpected, n);

   }

   /**
    * Testing isZero with empty entry
    * 
    * @Boundary
    */
   @test
   public void testIsZero() {
    NaturalNumber n = this.constructorTest();
    boolean isZero = n.isZero();
    boolean isZeroExpected = true;
    assertEquals(isZeroExpected, isZero);
   }

   /**
    * Testing isZero with non-zero entry
    * 
    * @Routine
    */
   @Test
   public void testIsZeroNonZeroNN() {
    NaturalNumber n = this.constructorTest(23);
    Boolean isZero = n.isZero();
    Boolean isZeroExpected = false;
    assertEquals(isZeroExpected, isZero);
    }
}
