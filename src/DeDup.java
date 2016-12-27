import org.apache.log4j.Level;
import org.apache.log4j.Logger;


import java.util.*;

/**
 * Created by MadanNellore on 12/27/16.
 */
public class DeDup {

    public static final Logger logger= Logger.getLogger(DeDup.class);

    public static int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19, 13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};



    /*

  Positives :
   1. Using streams, we can eliminate all the temporary variables and move the control logic into the library
   2. This version of the code is more compact, more readable, and less error prone.
   3. Streams don't have storage for values; they carry values from a source through a pipeline of computational steps.
   4. Preserve the input array order
  Negatives :
    1. Only Compiles on Java 8
    */

    public static int[] removeDuplicatesWithArrayStream(int[] inputArray) {

        if (inputArray != null) {
            if (inputArray.length == 1 || inputArray.length == 0)
                return inputArray;
            //This is only compatible with Java8
            // return Arrays.stream(inputArray).distinct().sorted().toArray()  returns distinct and sorted Array by adding the operation to pipeline.
            return Arrays.stream(inputArray).distinct().toArray();
        } else new DeDupException("Array is Null");

        return null;
    }

      /*

  Positives :
   1. Hash Set removes duplicates entry

  Negatives :
    1.  Not Sorted , Not Ordered
    2.  More error prone compared to Java Stream since implementation is mostly ClientSide
    */

    private static int[] removeDuplicatesWithHashSet(int[] inputArray) {

        if (inputArray != null) {
            if (inputArray.length == 1 || inputArray.length == 0)
                return inputArray;
            Set<Integer> integerHashSet = new HashSet<>();
            for (int i = 0; i < inputArray.length; i++) {
                integerHashSet.add(inputArray[i]);
            }

            int[] result = new int[integerHashSet.size()];
            int index = 0;
            Iterator<Integer> it = integerHashSet.iterator();
            while (it.hasNext()) {
                result[index++] = it.next();
            }
            return result;
        } else throw new DeDupException("Array is Null");

    }

      /*

  Positives :
    1.  LinkedHash Set removes duplicates entry
    2.  Preserve the input array order
  Negatives :
    1.  Not Sorted
    2.  More error prone compared to Java Stream since implementation is mostly ClientSide
    */

        private static int[] removeDuplicatesAndPreserveOrdertWithLinkedHashSet ( int[] inputArray){

            if (inputArray != null) {
                if (inputArray.length == 1 || inputArray.length == 0)
                    return inputArray;
                Set<Integer> integerHashSet = new LinkedHashSet<>();
                for (int i = 0; i < inputArray.length; i++) {
                    integerHashSet.add(inputArray[i]);
                }

                int[] result = new int[integerHashSet.size()];
                int index = 0;
                Iterator<Integer> it = integerHashSet.iterator();
                while (it.hasNext()) {
                    result[index++] = it.next();
                }

                return result;
            } else throw new DeDupException("Array is Null");

        }

    private static void logMe(String parameter){

      if(logger.isDebugEnabled()){
            logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : " + parameter);
        }
    }



    public static void main(String[] args) {

        logMe("Integer Array with Java Stream Preserve Order and Filter Duplicates "+Arrays.toString(removeDuplicatesWithArrayStream(randomIntegers)));
        logMe("Integer Array remove duplicates with HashSet Order not preserved "+Arrays.toString(removeDuplicatesWithHashSet(randomIntegers)));
        logMe("Integer Array using LinkedHashSet to preserve order and remove Duplicates"+Arrays.toString(removeDuplicatesAndPreserveOrdertWithLinkedHashSet(randomIntegers)));
    }
}
