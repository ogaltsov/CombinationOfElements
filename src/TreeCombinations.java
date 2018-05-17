import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeCombinations {

    /*
    This algorithm founds all combination of set
    using tree-algorithm with reсursion
    Amount of combinations:  2^N (N - amount of elements)
    _______________________________________________________________________________________
                                |1.2.3.4|
    _______________________________________________________________________________________
                         /                          \               \             \
    _______________________________________________________________________________________
                    |1._._|                        |2._._|          |3._._|       |4._._|
    _______________________________________________________________________________________
                /      |     \                     /     \              \
    _______________________________________________________________________________________
         |1.2._|    |1.3._|   |1.4._|          |2.3._|   |2.4._|         |3.4._|
    _______________________________________________________________________________________
        /      \          \                    /
    _______________________________________________________________________________________
    |1.2.3|   |1.2.4|    |1.3.4|          |2.3.4|
     ______________________________________________________________________________________
    */


    public static void main(String[] args) {
       int arr[] = {1,2,3,4,5,6};
       int powerCount = arr.length * arr.length;
       ArrayList<int[]> list = new ArrayList<>(powerCount);

       for(int i=1; i<=arr.length; i++) {
           checkCombinations(arr, list, new int[i], 0, 0);
       }

       //RESULT
        for(int[]combination: list){
            System.out.print("\r\n[ ");
           for(int i: combination){
               System.out.print(i+"; ");
           }
            System.out.print("]");
        }

    }

    private static void checkCombinations(int[] arr, List<int[]> list, int data[], int start, int index)  {

        if (index == data.length) {
            list.add(Arrays.copyOf(data, data.length));
        }
            for (int i = start;  i<arr.length && index<data.length;  i++) {
                data[index] = arr[i];
                checkCombinations(arr, list, data, i+1, index+1);
            }
        }
    }

