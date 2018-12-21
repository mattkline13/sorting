import java.io.File; 
import java.util.Scanner;

public class ShellSort {
    private static int MAX_SIZE = 1000000;
    private static int[] my_array = new int[MAX_SIZE];
    private static String gaps = "";

    public static void main(String args[]) throws Exception {
        long startTime = System.nanoTime();
        
        readFileToArray(args[0]);
        sort();
        printArray();
        
        long endTime = System.nanoTime();
        System.out.println("Gap spacing of " + gaps);
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
        for (int gap = my_array.length / 2; gap > 0; gap /= 2) {
            gaps = gaps + ", " + gap;
            for (int i = gap; i < my_array.length; i += 1) {
                int temp = my_array[i];

                int j;
                for (j = i; j >= gap && my_array[j - gap] > temp; j -= gap) {
                    my_array[j] = my_array[j - gap];
                }

                my_array[j] = temp;
            } 
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
