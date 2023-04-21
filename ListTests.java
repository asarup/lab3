import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ListTests {

    private static final String[] STR_ARR_1 = {"abc", "bc", "c"}, STR_ARR_2 = {"def", "ef", "f"};
    private List<String> stringList1, stringList2;
    StringChecker s1;

    @Before
    public void setUp() {
        stringList1 = new ArrayList<String>(Arrays.asList(STR_ARR_1));
        stringList2 = new ArrayList<String>(Arrays.asList(STR_ARR_2));
        s1 = new StringContains("b");
    }

    @Test
    public void testFilter() {
        assertArrayEquals(new String[]{"abc","bc"}, ListExamples.filter(stringList1, s1).toArray());
    }

    @Test
    public void testMerge() {
        assertArrayEquals(new String[]{"abc","bc","c","def","ef","f"}, 
          ListExamples.merge(stringList1, stringList2).toArray());
    }

}
