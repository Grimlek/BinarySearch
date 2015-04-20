package binarysearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    protected List <String> list;

    BinarySearch () {
        list = new ArrayList <> ();
        try {
            String line = null;
            BufferedReader reader;
            reader = new BufferedReader (new FileReader ("names"));
            while ( (line = reader.readLine ()) != null) {
                list.add (line);
            }
        } catch (IOException ex) {
            ex.printStackTrace ();
        }
    }

    private void insertionSort () {
        int x, y;
        String value;
        String [] array = list.toArray (new String [list.size ()]);
        for (x = 1; x < array.length; x++) { 
            value = array [x]; 
            while (y >= 0) {
                if (value.compareTo (array [y]) < 0) {
                    array [y + 1] = array [y];
                    y--;
                } else {
                    break; 
                }
                array [y + 1] = value;
            }
        }
        list.clear ();
        for (x = 0; x < array.length; x++) {
            list.add (array [x]);
        }
    }

    public void binarySearch (String search) {
        insertionSort () ;        
        String [] array = list.toArray (new String [list.size ()]);
        int low = 0;
        int mid = 0;
        int high = array.length;

        while (low < high) {
            mid = (low + high) / 2;
            if (search.compareTo (array [mid]) < 0) {
                high = mid;
            }
            if (search.compareTo (array [mid]) > 0) {
                low = mid;
            }
            if (mid == low + ( (high - low) / 2)) {
                break;
            }
        }
        if (array [mid].equals (search)) {
            System.out.println ("Name was found! " + array [mid]);
        } else {
            System.out.println ("Could not find name; " + search);
        }
    }

    public static void main (String [] args) {
        Scanner scanner = new Scanner (System.in);
        BinarySearch example = new BinarySearch ();
        example.insertionSort ();

        while (true) {
            System.out.println ("Please enter the name you wish to search or 1 to quit!");
            String input = scanner.nextLine ();
            if (input.equals ("1")) {
                break;
            } else {
                char upperCase = Character.toUpperCase (input.charAt (0));
                input = upperCase + input.substring (1);
                example.binarySearch (input);
                System.out.println ("\r\n");
            }
        }
    }
}