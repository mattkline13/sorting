import java.io.File; 
import java.util.Scanner;

public class InsertionSort {
    private static int MAX_SIZE = 1000000;
    private static int[] my_array = new int[MAX_SIZE];

    public static void main(String args[]) throws Exception {
        long startTime = System.nanoTime();
        
        readFileToArray(args[0]);
        sort();
        printArray();
        
        long endTime = System.nanoTime();
        System.out.println("Took "+ (endTime - startTime)/1000000000 + " sec"); 
    }

    public static void readFileToArray(String filename) throws Exception {
        int index = 0;
        File file = new File(filename); 
        Scanner input = new Scanner(file); 
  
        while (input.hasNextLine()) {
            my_array[index] = Integer.parseInt(input.nextLine());
            index++;
        }
    }

    public static void sort() {
        for (int index = 0; index < my_array.length; index++) {
            int key = my_array[index];
            int j = index-1;

            while (j>=0 && my_array[j] > key) {
                my_array[j+1] = my_array[j];
                j = j-1;
            }
            my_array[j+1] = key;
        }
    }

    public static void printArray() {
        System.out.println();

        int size = my_array.length;
        for (int index = 0; index < size; index++) {
            System.out.println(my_array[index]);
        }

        System.out.println();
    }
}
