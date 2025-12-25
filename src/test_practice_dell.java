import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * add method: adding the element, if the array is full - do the resizing, don't add duplicates - return false,
 * remove method: it should remove the element- return true, contains becomes false
 * , if the element is not present - return false,
 * removing from empty set should return false, it should not break existing elements
 * contains method: if existing element - return true, not existing return false.
 */
public class test_practice_dell {

    @Test
    public void testAdd(){
        practice_dell set = new practice_dell();
        assertTrue(set.add(10));
        assertTrue(set.contains(10));
    }
    @Test
    public void testAdd1(){
        practice_dell set = new practice_dell();
        assertFalse(set.contains(10));
    }

    @Test
    public void testAdd2(){
        practice_dell set = new practice_dell();
        System.out.println(set.array.length);
        assertTrue(set.add(10));
        assertTrue(set.add(20));
        assertTrue(set.add(30));
        assertTrue(set.add(40));
        assertTrue(set.add(50));
        assertTrue(set.add(60));
        System.out.println(set.array.length);
    }

    @Test
    public void testAdd3(){
        practice_dell set = new practice_dell();
        assertTrue(set.add(10));
        assertTrue(set.add(20));
        assertTrue(set.add(30));
        assertTrue(set.add(40));
        assertTrue(set.add(50));
        assertTrue(set.add(60));
        assertFalse(set.add(10));
    }

    @Test
    public void removeElement(){
        practice_dell test = new practice_dell();
        test.add(2);
        assertTrue(test.remove(2));
        assertFalse(test.contains(2));
    }

    @Test
    public void removeElement1(){
        practice_dell test = new practice_dell();
        assertFalse(test.remove(2));
        assertFalse(test.contains(2));
    }

    @Test
    public void removeElement2(){
        practice_dell test = new practice_dell();
        test.add(22);
        assertFalse(test.remove(2));
        assertFalse(test.contains(2));
    }

    @Test
    public void removeElement3(){
        practice_dell test = new practice_dell();
        test.add(22);
        test.add(23);
        test.add(24);
        assertTrue(test.remove(22));
        assertFalse(test.contains(22));
        assertTrue(test.contains(23));
        assertTrue(test.contains(24));
    }

    @Test
    public void contains() {
        practice_dell test = new practice_dell();
        assertFalse(test.contains(2));
    }
}
