package pt.ipp.isep.dei.esoft.labproject.problem.one.version.one;

public class ProblemOne {

    /**
     * Sort an array of integers in ascending order. Implementation (1/2).
     *
     * @param array Array of integers.
     * @return Sorted array of integers.
     */
    public static int[] sortArrayAscending(int[] array) {
        if (array== null){
            return null;
        }else{
            int[] sortedArray = array.clone();
            for (int i = 0; i < sortedArray.length; i++) {
                for (int j = i + 1; j < sortedArray.length; j++) {
                    if (sortedArray[i] > sortedArray[j]) {
                        int temp = sortedArray[i];
                        sortedArray[i] = sortedArray[j];
                        sortedArray[j] = temp;
                    }
                }
            }
            return sortedArray;
        }


    }
}