import static org.junit.Assert.*;
import org.junit.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class FileTests {
    

    private File someFiles, a, moreFiles, b, c, evenMoreFiles, d, e;
    private Object[] expect1, expect2, expect3, res1, res2, res3;

    @Before
    public void setUp() {
        someFiles = new File("/Users/arjsa/Local Documents/GitHub/lab3/some-files");
        a = new File(someFiles, "a.txt");
        moreFiles = new File(someFiles, "more-files");
        b = new File(moreFiles, "b.txt");
        c = new File(moreFiles, "c.java");
        evenMoreFiles = new File(someFiles, "even-more-files");
        d = new File(evenMoreFiles, "d.java");
        e = new File(evenMoreFiles, "e.txt");

        expect1 = new File[]{a, b, c, d, e};
        expect2 = new File[]{b, c};
        expect3 = new File[]{a};       
    }
    
    /*
        It was nearly impossible for me to have getFiles() preserve the order
        of the files, so I sorted the expected and actual results before comparing
        them so that order wouldn't matter during the assertArrayEquals tests.
     */
    @Test
    public void testGetFiles() throws IOException {
        res1 = FileExample.getFiles(someFiles).toArray();
        Arrays.sort(res1);
        Arrays.sort(expect1);
        assertArrayEquals(expect1, res1);

        res2 = FileExample.getFiles(moreFiles).toArray();
        Arrays.sort(res2);
        Arrays.sort(expect2);
        assertArrayEquals(expect2, res2);

        res3 = FileExample.getFiles(a).toArray();
        Arrays.sort(res3);
        Arrays.sort(expect3);
        assertArrayEquals(expect3, res3);

    }

    
}
