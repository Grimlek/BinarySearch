/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Charles
 */
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
        //String[] array = new String[size()];
        String value;

        String [] array = list.toArray (new String [list.size ()]);

        for (x = 1; x < array.length; x++) {    // Loop through the whole  
            //  array, starting with the second element   

            value = array [x];  // get the value of that second element  

            y = x - 1;  // Make a placeholder that is going to let us look  
            // at the elements that come before the value we're looking  
            // at  

            while (y >= 0) {  // While our placeholder is not going to go  
                // past the beginning of the array, and the value in our  
                // hand is bigger than the one before it...  
                if (value.compareTo (array [y]) < 0) {  // compare the  
                    // value with the previous one. Is it less  
                    // than the previous value?  

                    array [y + 1] = array [y];  // if so, take that previous  
                    // value and slide it over.  

                    y--;  // move placeholder down so we 
                    //compare the next value in the list  

                } else {
                    
                    break;  // If our placeholder reaches an value that's  
                    // less than or equal to the value, then  
                    // we're good
                }

                array [y + 1] = value; // Use our placeholder to figure  
                // out where we need to put our value. Since our  
                // placeholder is stuck on the element that is less  
                // than or equal to ours (or it managed to hit -1 and  
                // stopped the while loop), we need to add 1 to it in  
                // order to find the place where the value still  belongs.  
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
