// Create a program that reads data file and returns the occurrences of ints -
// https://runestone.academy/runestone/books/published/java4python/Java4Python/javadatatypes.html

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Histogram {

    public static void main(String[] args) {
        // declare scanner variable -null before reading data
        Scanner data = null;
        // Declare array that will contain int value counts for values 0...9
        // We could also, instead of ArrayList, use:
        // Integer[] count = {0,0,0,0,0,0,0,0,0,0};
        ArrayList<Integer> count;
        // Declare int to use as index in array
        Integer idx;

        // Try to open data.dat, if not found or any errors, print out exception and
        // exit
        try {
            data = new Scanner(new File("data.dat"));
        } catch (IOException e) {
            System.out.println("File could not be opened!!");
            e.printStackTrace();
            System.exit(0);
        }

        // Assign array of length 10 to count
        count = new ArrayList<Integer>(10);
        for (Integer i = 0; i < 10; i++) {
            // Set value 0 for each array item
            count.add(i, 0);
        }
        // Check every character in file. If there is next int, add +1 to corresponding
        // count index
        while (data.hasNextInt()) {
            // Asign int value to index
            idx = data.nextInt();
            // Set value of current count + 1 to count array value with index = found value
            count.set(idx, count.get(idx) + 1);
        }
        // Reset index value to print numbers 0...9
        idx = 0;
        // for each count in count array... -Array is ordered from 0 to 9
        for (Integer i : count) {
            // Print idx (current key) and i (current count for key)
            System.out.println(idx + " ocurred " + i + " times");
            // Index increment
            idx++;
        }
    }

}
