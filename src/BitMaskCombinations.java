import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BitMaskCombinations {

    /*
This algorithm founds all combination of set
using bit-mask
Amount of combinations:  2^N (N - amount of elements)
__________________
 bit mask for 3

 000  -  0
 001  -  1
 010  -  2
 100  -  4
 011  -  3
 110  -  6
 101  -  5
 111  -  7
 ---8 combinations
 2^3 = 2*2*2 = 8
__________________
 123 * bit mask(3);

 123 * 000 = 0
 123 * 100 = 1
 123 * 010 = 2
 123 * 001 = 3
 123 * 110 = 12
 123 * 011 = 23
 123 * 101 = 13
 123 * 111 = 123
 _________________
 */



    public static void main(String[] args) {

        int []arrOfElements = {1,2,3,4,5,6};

        int powerCount = arrOfElements.length * arrOfElements.length;
        ArrayList<List<Integer>> listOfCombinations = new ArrayList<>(powerCount);

        for(int i=0; i<powerCount; i++){
            ArrayList<Integer> combination = new ArrayList<>(arrOfElements.length);
            for(int j=arrOfElements.length-1; j>=0; j--){
                if(!((1<<j & i)==0)){
                    combination.add(arrOfElements[arrOfElements.length-1-j]);
                }
            }
            if(combination.size()!=0)
                listOfCombinations.add(combination);
        }




        //PRINT RESULT
        Collections.sort(listOfCombinations, (o1, o2) -> {
            if(o1.size()==o2.size())
                return 0;
            else return o1.size()<o2.size() ? -1 : 1;
        });

        for(List<Integer> lis: listOfCombinations ){
            System.out.print("\r\n[ ");
            for(Integer i : lis){
                System.out.print(i+"; ");
            }
            System.out.print("]");
        }
    }
}

