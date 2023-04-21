import static org.junit.Assert.*;
import org.junit.*;

public class LinkedListTests {
    
    private LinkedList list1;
    private Node node1, node2;

    @Before
    public void setUp() {
        list1 = new LinkedList();
        node2 = new Node(2, null);
        node1 = new Node(1, node2);
        list1.root = node1;
    }

    @Test
    public void testPrepend() {
        list1.prepend(0);
        assertEquals(0, list1.root.value);
        assertEquals(1, list1.root.next.value);
    }

    @Test
    public void testAppend() {
        list1.append(3);
        assertEquals(2, list1.root.next.value);
        assertEquals(3, list1.root.next.next.value);
    }

    @Test
    public void testFirst() {
        assertEquals(1, list1.first());
    }

    @Test
    public void testLast() {
        assertEquals(2, list1.last());
    }

    @Test
    public void testToString() {
        assertEquals("1 2 ", list1.toString());
    }

    @Test
    public void testLength() {
        assertEquals(2, list1.length());
    }
}
