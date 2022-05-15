import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class MergeTests {
    
    @Test
    public void testMerge()
    {
        int[] a = {1,3,5};
        int[] b = {2,4,6};
        ArrayList<Object> arr1 = new ArrayList<Object>();
        ArrayList<Object> arr2 = new ArrayList<Object>();
        addToList(a, arr1);
        addToList(b, arr2);

        MergeSort ms = new MergeSort();
        IntMap im = (e) -> {return Integer.parseInt(e.toString());};
        ArrayList<Object> result = ms.merge(arr1, arr2, im);
        
        int[] r = {1,2,3,4,5,6};
        ArrayList<Object> expected = new ArrayList<Object>();
        addToList(r, expected);
        assertEquals(expected, result);

    }

    void addToList(int[] arrWithContent, ArrayList<Object> arr)
    {
        for (int i : arrWithContent)
        {
            arr.add(i);
        }
    }

    @Test
    public void testMergeSort()
    {
        int[] a = {3,5,1,2,4};
        ArrayList<Object> arr1 = new ArrayList<Object>();
        addToList(a, arr1);

        MergeSort ms = new MergeSort();
        IntMap im = (e) -> {return Integer.parseInt(e.toString());};
        ArrayList<Object> result = ms.sort(arr1, im);
        
        int[] r = {1,2,3,4,5};
        ArrayList<Object> expected = new ArrayList<Object>();
        addToList(r, expected);
        assertEquals(expected, result);
        System.out.println(result);
    }
}
