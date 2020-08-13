// Create a program that reads data file and returns the occurrences of ints -
// https://runestone.academy/runestone/books/published/java4python/Java4Python/javadatatypes.html

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Histogram {

    public static void main(String[] args) {
        Scanner data = null;
        ArrayList<Integer> count;
        Integer idx;

        try {
            data = new Scanner(new File("data.dat"));
        } catch (IOException e) {
            System.out.println("File could not be opened!!");
            e.printStackTrace();
            System.exit(0);
        }

        count = new ArrayList<Integer>(10);
        for (Integer i = 0; i < 10; i++) {
            count.add(i, 0);
        }
        // Check every character in file. If there is next int, add +1 to corresponding
        // count index
        while (data.hasNextInt()) {
            idx = data.nextInt();
            count.set(idx, count.get(idx) + 1);
        }

        idx = 0;
        for (Integer i : count) {
            System.out.println(idx + " ocurred " + i + " times");
            idx++;
        }
    }

}
