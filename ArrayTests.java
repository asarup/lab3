import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	
  private int[] input1, sameRef;
  private double[] input2;

  @Before
  public void setUp() {
    input1 = new int[]{1, 3, 5, 7, 9};
    input2 = new double[]{3.0, 3.0, 4.0, 5.0, 6.0};
    sameRef = input1;
  }

  
  @Test 
	public void testReverseInPlace() {
    ArrayExamples.reverseInPlace(input1);
    assertEquals(sameRef, input1);
    assertArrayEquals(new int[]{9, 7, 5, 3, 1}, input1);
	}


  @Test
  public void testReversed() {
    assertNotEquals(sameRef, ArrayExamples.reversed(input1));
    assertArrayEquals(new int[]{9, 7, 5, 3, 1}, ArrayExamples.reversed(input1));
  }

  @Test
  public void testAverageWithoutLowest() {
    assertEquals(4.5, ArrayExamples.averageWithoutLowest(input2), 0.001);
  }
}
