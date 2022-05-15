import java.util.ArrayList;

public class MergeSort
{
    public ArrayList<Object> sort(ArrayList<Integer> arr)
    {
        ArrayList<Object> arrObj = new ArrayList<>(arr);
        IntMap intMap = obj -> {return Integer.parseInt(obj.toString());};
        return sort(arrObj, intMap);
    }


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

    public ArrayList<Object> merge(ArrayList<Object> arr1, ArrayList<Object> arr2, IntMap intMap)
    {
        ArrayList<Object> bufferArr = new ArrayList<Object>();
        while (arr1.size() > 0 && arr2.size() > 0)
        {
            int a = intMap.getInt(arr1.get(0));
            int b = intMap.getInt(arr2.get(0));
            if (a < b)
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

