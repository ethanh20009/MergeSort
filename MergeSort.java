import java.util.ArrayList;
import java.util.Objects;

public class MergeSort
{
    @FunctionalInterface
    public interface IntMap {
        
        boolean getInt(Object obj, Object obj2);
        
    }

    /**
     * Sorts list of strings in alphabetical order
     * @param arr Array containing strings to be sorted
     * @return Sorted ArrayList of strings
     */
    public ArrayList<String> sort(ArrayList<String> arr)
    {
        ArrayList<Object> arrStr = new ArrayList<Object>(arr);
        IntMap im = (obj, obj2) -> {
            return obj.toString().compareTo(obj2.toString()) < 0;
        };
        ArrayList<Object> result = sort(arrStr, im);
        ArrayList<String> resultStr = new ArrayList<String>();
        for (Object i : result)
        {
            resultStr.add(i.toString());
        }
        return resultStr;
    }

    /**
     * Sort list of objects using the given IntMap
     * @param arr Array containing objects to be sorted
     * @param intMap Function to compare two objects
     * @return
     */
    public ArrayList<Object> sort(ArrayList<Object> arr, IntMap intMap)
    {
        if (arr.size() > 1)
        {
            ArrayList<Object> arr1 = new ArrayList<Object>(arr.subList(0, arr.size()/2));
            ArrayList<Object> arr2 = new ArrayList<>(arr.subList(arr.size()/2, arr.size()));
            return merge(sort(arr1, intMap), sort(arr2, intMap), intMap);
        }
        if (arr.size() == 1)
        {
            return arr;
        }
        if (arr.size() == 0)
        {
            return new ArrayList<Object>();
        }
        return null;
    }

    /**
     * Merge two sorted lists
     * @param arr1 First sorted list
     * @param arr2 Second sorted list
     * @param intMap Function to compare two objects
     * @return Merged list
     */
    public ArrayList<Object> merge(ArrayList<Object> arr1, ArrayList<Object> arr2, IntMap intMap)
    {
        ArrayList<Object> bufferArr = new ArrayList<Object>();
        while (arr1.size() > 0 && arr2.size() > 0)
        {

            if (intMap.getInt(arr1.get(0), arr2.get(0)))
            {
                bufferArr.add(arr1.get(0));
                arr1.remove(0);
            }
            else{
                bufferArr.add(arr2.get(0));
                arr2.remove(0);
            }
        }

        bufferArr.addAll(arr1);
        bufferArr.addAll(arr2);
        return bufferArr;
    }


}

